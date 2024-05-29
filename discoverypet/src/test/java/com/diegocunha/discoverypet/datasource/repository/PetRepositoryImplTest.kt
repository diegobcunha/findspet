package com.diegocunha.discoverypet.datasource.repository

import androidx.paging.testing.ErrorRecovery
import androidx.paging.testing.asSnapshot
import com.diegocunha.datasource.network.network.DiscoveryPetService
import com.diegocunha.discoverypet.fixture.petResponse
import com.diegocunha.testutils.helpers.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import org.junit.Before
import org.junit.Test

class PetRepositoryImplTest : BaseUnitTest() {

    private lateinit var repositoryImpl: PetRepositoryImpl

    private val source = mockk<DiscoveryPetService>()

    @Before
    fun setup() {
        repositoryImpl = PetRepositoryImpl(source)
    }

    @Test
    fun `WHEN pets source are required with success THEN should return valid data`() =
        runBlockingTest {
            coEvery { source.getPets(any(), any(), any()) } returns petResponse

            val response = repositoryImpl.searchPets(10).asSnapshot()

            assertNotNull(response)

            coVerify { source.getPets(1, 10) }
        }

    @Test
    fun `WHEN pet source returns error THEN should return error correctly`() = runBlockingTest {
        coEvery { source.getPets(any(), any(), any()) }.throws(Exception())

        val response = repositoryImpl.searchPets(10).asSnapshot(
            onError = { ErrorRecovery.RETURN_CURRENT_SNAPSHOT }
        )
        assertTrue(response.isEmpty())
    }
}