package com.prabhakar.basis_assignment.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.prabhakar.basis_assignment.R
import com.prabhakar.basis_assignment.remote.data.DataModel
import com.prabhakar.basis_assignment.remote.data.ResponseModel
import com.prabhakar.basis_assignment.view.viewholder.QuotesViewHolder

class QuotesAdapter(private val quotesLists: MutableList<ResponseModel>) :
    RecyclerView.Adapter<QuotesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quotes_layout, parent, false)
        return QuotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        val model=quotesLists[position]
        holder.setQuotesData(model)
    }

    override fun getItemCount(): Int {
        return quotesLists.size
    }
}