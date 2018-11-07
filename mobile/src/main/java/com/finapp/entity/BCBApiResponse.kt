package com.finapp.entity

import com.google.gson.annotations.SerializedName

data class BCBApiResponse(
    @field:SerializedName("data") val data: String,
    @field:SerializedName("valor") val value: String
)