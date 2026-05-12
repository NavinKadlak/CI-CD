package com.nsk.testcicd.testUtils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import kotlin.coroutines.EmptyCoroutineContext.get

@OptIn(ExperimentalCoroutinesApi::class)
class TestDispatcherProvider (
    private val testDispatcher: TestDispatcher = StandardTestDispatcher()
    ) : TestWatcher() {

        /*override val main: CoroutineDispatcher
        get() = dispatcher

        override val io: CoroutineDispatcher
        get() = dispatcher

        override val default: CoroutineDispatcher
        get() = dispatcher*/

    override fun starting(description: Description) {

        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {

        Dispatchers.resetMain()
    }
    }