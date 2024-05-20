package com.diegocunha.discoverypet.domain.usecase

import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import androidx.paging.testing.asSnapshot
import com.diegocunha.discoverypet.datasource.repository.PetRepository
import com.diegocunha.testutils.helpers.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FindPetUseCaseTest : BaseUnitTest() {

    private lateinit var useCase: FindPetUseCase

    private val repository = mockk<PetRepository>()

    @Before
    fun setup() {
        useCase = FindPetUseCase(repository)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `WHEN returns success data THEN should return valid information`() = runBlockingTest {
        coEvery { repository.searchPets(any()) } returns flow {
            emit(
                PagingData.from(
                    listOf(pet),
                    LoadStates(
                        refresh = LoadState.NotLoading(true),
                        prepend = LoadState.NotLoading(true),
                        append = LoadState.NotLoading(true)
                    )
                )
            )
        }

        val result = useCase(1).asSnapshot()
        coVerify(exactly = 1) { repository.searchPets(1) }
        TestCase.assertTrue(result.isNotEmpty())
    }

    @Test
    fun `WHEN returns error data THEN should return valid information`() = runBlockingTest {
        coEvery { repository.searchPets(any()) } returns flow {
            emit(
                PagingData.empty()
            )
        }

        val job = launch {
            useCase(1).toList()
        }

        coVerify(exactly = 1) { repository.searchPets(1) }
        job.cancel()
    }


}