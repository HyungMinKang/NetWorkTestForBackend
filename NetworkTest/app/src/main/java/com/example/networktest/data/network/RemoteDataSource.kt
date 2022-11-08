package com.example.networktest.data.network

import com.example.networktest.data.dto.UserDto

class RemoteDataSource (private val api:Api):DataSource{
    override suspend fun api1(): UserDto{
        return api.getLoginAccess()
    }

}