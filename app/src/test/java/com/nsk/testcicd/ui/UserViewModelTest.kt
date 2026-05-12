package com.nsk.testcicd.ui

import com.nsk.testcicd.domain.repository.UserRepository
import com.nsk.testcicd.domain.usecase.GetUserUseCase
import com.nsk.testcicd.testUtils.TestDispatcherProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@OptIn(ExperimentalCoroutinesApi::class)
class UserViewModelTest {


    @get:Rule
    val mainDispatcherRule = TestDispatcherProvider()
    private val repository = mock(UserRepository::class.java)


    @Test
    fun `loadUser should update username state`() = runTest {

        // Arrange
        `when`(repository.getUserName()).thenReturn("Navin")

        val useCase = GetUserUseCase(repository)


        val viewModel = UserViewModel(useCase)

        // Act
        viewModel.loadUser()

        advanceUntilIdle()

        // Assert
        assertEquals("Navin", viewModel.userName.value)
    }
}