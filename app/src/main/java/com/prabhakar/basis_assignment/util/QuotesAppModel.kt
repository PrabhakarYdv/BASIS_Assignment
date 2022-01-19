package com.prabhakar.basis_assignment.util

import com.prabhakar.basis_assignment.remote.data.DataModel
import com.prabhakar.basis_assignment.remote.data.ResponseModel

sealed class QuotesAppModel {
    data class OnSuccess(val responseModel: ResponseModel) : QuotesAppModel()

    data class OnFailure(val error: String) : QuotesAppModel()

//    data class onSuccess(val result: MutableList<DataModel>):QuotesAppModel()
}
