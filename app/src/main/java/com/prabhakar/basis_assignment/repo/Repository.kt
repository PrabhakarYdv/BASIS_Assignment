package com.prabhakar.basis_assignment.repo

import com.prabhakar.basis_assignment.remote.Network
import com.prabhakar.basis_assignment.remote.data.DataModel
import com.prabhakar.basis_assignment.remote.data.ResponseModel
import io.reactivex.rxjava3.core.Observable

class Repository() {
    private val apiService = Network.provideAPIService()

    //    Fetching Data From server and Return to the View Model
    fun getQuotesFromServer(): Observable<ResponseModel> {
        return apiService.getQuotes()
    }

}