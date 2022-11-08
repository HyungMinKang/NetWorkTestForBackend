package com.example.networktest.data.repository

import com.example.networktest.data.dto.UserDto
import com.example.networktest.data.network.DataSource
import com.example.networktest.domain.Repository

class RepositoryImpl(private val dataSource: DataSource): Repository{
    override suspend fun apiTest1(): UserDto {
        return dataSource.api1()
    }

}