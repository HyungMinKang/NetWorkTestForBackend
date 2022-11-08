package com.example.networktest.domain

import com.example.networktest.data.dto.UserDto

interface Repository {
    suspend fun apiTest1(): UserDto
}