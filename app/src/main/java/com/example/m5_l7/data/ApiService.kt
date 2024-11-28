package com.example.m5_l7.data

import com.example.m5_l7.data.models.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int
    ) : BaseResponse

}