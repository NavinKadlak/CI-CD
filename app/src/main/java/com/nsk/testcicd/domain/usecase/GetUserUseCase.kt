package com.nsk.testcicd.domain.usecase

import com.nsk.testcicd.domain.repository.UserRepository

class GetUserUseCase ( private val repository: UserRepository
) {

    suspend operator fun invoke(): String {

        return repository.getUserName()
    }
}