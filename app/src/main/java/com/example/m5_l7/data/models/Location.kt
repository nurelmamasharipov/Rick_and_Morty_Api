package com.example.m5_l7.data.models


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)