package com.nsk.testcicd.domain.repository

interface UserRepository {
    suspend fun getUserName(): String

}