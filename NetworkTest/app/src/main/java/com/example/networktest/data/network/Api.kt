package com.example.networktest.data.network

import com.example.networktest.data.dto.UserDto
import retrofit2.http.GET

interface Api {
    @GET("/getdata/1")
    suspend fun getLoginAccess(): UserDto

}