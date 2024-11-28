package com.example.m5_l7.data.models


import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("info")
    val info: Info? = null,
    @SerializedName("characters")
    val characters: List<Character>? = null
)