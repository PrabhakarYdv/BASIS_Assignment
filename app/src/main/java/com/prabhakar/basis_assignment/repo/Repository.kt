package com.prabhakar.basis_assignment.repo

import com.prabhakar.basis_assignment.remote.APIService
import com.prabhakar.basis_assignment.remote.data.DataModel
import io.reactivex.Observable
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: APIService) {

//    Fetching Data From server and Return to the View Model
    fun getQuotesFromServer(): Observable<DataModel> {
        return apiService.getQuotes()
    }

}