package com.diegocunha.discoverypet.ui.home

import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import androidx.paging.testing.asSnapshot
import com.diegocunha.discoverypet.domain.usecase.FindPetUseCase
import com.diegocunha.testutils.helpers.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class HomeViewModelTest : BaseUnitTest() {

    private lateinit var viewModel: HomeViewModel

    private val useCase = mockk<FindPetUseCase>()

    @Before
    fun setup() {
        viewModel = HomeViewModel(testDispatchersProvider, useCase)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `WHEN returns success data THEN should return valid information`() = runBlockingTest {
        coEvery { useCase(any()) } returns flow {
            emit(
                PagingData.from(
                    listDomain,
                    LoadStates(
                        refresh = LoadState.NotLoading(true),
                        prepend = LoadState.NotLoading(true),
                        append = LoadState.NotLoading(true)
                    )
                )
            )
        }

        val result = viewModel.pagingFlow.asSnapshot()
        coVerify(exactly = 1) { useCase(any()) }
        assertTrue(result.isNotEmpty())
    }

    @Test
    fun `WHEN returns error data THEN should return valid information`() = runBlockingTest {
        coEvery { useCase(any()) } returns flow {
            emit(
                PagingData.empty()
            )
        }

       val job = launch {
           viewModel.pagingFlow.toList()
       }

        coVerify(exactly = 1) { useCase(any()) }
        job.cancel()
    }
}