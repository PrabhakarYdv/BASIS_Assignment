package com.prabhakar.basis_assignment.remote.data

import com.google.gson.annotations.SerializedName

data class DataModel(

    @SerializedName("id") val id: Int,
    @SerializedName("text") val text: String
)