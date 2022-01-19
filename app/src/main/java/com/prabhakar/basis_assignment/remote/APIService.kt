package com.prabhakar.basis_assignment.remote

import com.prabhakar.basis_assignment.remote.data.DataModel
import com.prabhakar.basis_assignment.remote.data.ResponseModel
import com.prabhakar.basis_assignment.util.Constraints
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface APIService {
    @GET(Constraints.END_POINT)
    fun getQuotes(): Observable<ResponseModel>
}