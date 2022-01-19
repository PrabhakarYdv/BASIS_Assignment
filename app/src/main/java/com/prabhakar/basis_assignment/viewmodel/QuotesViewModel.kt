package com.prabhakar.basis_assignment.viewmodel

import androidx.lifecycle.ViewModel
import com.prabhakar.basis_assignment.remote.data.DataModel
import com.prabhakar.basis_assignment.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observable
import javax.inject.Inject

@HiltViewModel
class QuotesViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

//    Taking Data from Repository Class giving to subscribers views which view will subscribe this ViewModel class

    fun getAllQuotes(): Observable<DataModel> {
        return repository.getQuotesFromServer()
    }
}