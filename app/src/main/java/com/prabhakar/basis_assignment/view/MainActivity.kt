package com.prabhakar.basis_assignment.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.prabhakar.basis_assignment.R
import com.prabhakar.basis_assignment.remote.data.DataModel
import com.prabhakar.basis_assignment.remote.data.ResponseModel
import com.prabhakar.basis_assignment.util.QuotesAppModel
import com.prabhakar.basis_assignment.view.adapter.QuotesAdapter
import com.prabhakar.basis_assignment.viewmodel.QuotesViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: QuotesViewModel
    lateinit var quotesAdapter: QuotesAdapter
    private var quotesList = mutableListOf<ResponseModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(QuotesViewModel::class.java)
//        starting loading animation
        loading.startShimmerAnimation()
        buildList()
        setRecyclerView()


    }

    private fun buildList() {
        viewModel.getAllQuotes()
        viewModel.liveData.observe(this, Observer {
            it?.run {
                when (this) {
                    is QuotesAppModel.OnSuccess -> {
                        loading.stopShimmerAnimation()
                        loading.isVisible=false
                        recyclerview.visibility= View.VISIBLE
                        quotesList= this.responseModel.data as MutableList<ResponseModel>
                        quotesList.addAll(mutableListOf(this.responseModel))
                        setRecyclerView()
                        quotesAdapter.notifyDataSetChanged()
                    }
                    is QuotesAppModel.OnFailure -> {
                        Toast.makeText(this@MainActivity, this.error, Toast.LENGTH_SHORT).show()
                    }
//                    is QuotesAppModel.onSuccess -> {
//                        quotesList=it.result
//                        quotesAdapter.notifyDataSetChanged()
//                    }
                }
            }
        })
        viewModel.getAllQuotes()
    }
    
    //    Setting the RecyclerView
    private fun setRecyclerView() {
        quotesAdapter = QuotesAdapter(quotesList)
        recyclerview.layoutManager =
            LinearLayoutManager(this)
        recyclerview.adapter = quotesAdapter
    }
}