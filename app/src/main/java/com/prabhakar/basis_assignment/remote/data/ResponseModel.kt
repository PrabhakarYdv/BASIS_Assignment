package com.prabhakar.basis_assignment.remote.data

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("data") val data: List<DataModel>
)