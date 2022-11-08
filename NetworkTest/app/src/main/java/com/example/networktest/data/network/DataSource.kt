package com.example.networktest.data.network

import com.example.networktest.data.dto.UserDto

interface DataSource {
    suspend fun api1(): UserDto
}