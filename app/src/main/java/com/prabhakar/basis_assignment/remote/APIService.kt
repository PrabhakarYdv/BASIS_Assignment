package com.prabhakar.basis_assignment.remote

import com.prabhakar.basis_assignment.Constraints
import com.prabhakar.basis_assignment.remote.data.DataModel
import io.reactivex.Observable
import retrofit2.http.GET

interface APIService {
    @GET(Constraints.END_POINT)
    fun getQuotes(): Observable<DataModel>
}