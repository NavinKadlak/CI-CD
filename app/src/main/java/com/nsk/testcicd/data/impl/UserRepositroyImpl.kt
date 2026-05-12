package com.nsk.testcicd.data.impl

import com.nsk.testcicd.domain.repository.UserRepository

class UserRepositoryImpl : UserRepository {

    override suspend fun getUserName(): String {

        return "Navin"
    }
}