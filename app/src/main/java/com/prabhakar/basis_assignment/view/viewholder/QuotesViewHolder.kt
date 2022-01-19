package com.prabhakar.basis_assignment.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.prabhakar.basis_assignment.remote.data.ResponseModel
import kotlinx.android.synthetic.main.quotes_layout.view.*

class QuotesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun setQuotesData(model: ResponseModel) {
        view.apply {
            quotesId.text = model.data[adapterPosition].id.toString()
            quotes.text = model.data[adapterPosition].text
        }
    }
}