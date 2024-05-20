package com.diegocunha.discoverypet.datasource.repository.source

import androidx.paging.PagingSource
import com.diegocunha.discoverypet.datasource.network.DiscoveryPetService
import com.diegocunha.discoverypet.fixture.petResponse
import com.diegocunha.testutils.helpers.BaseUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class PetSourceTest : BaseUnitTest() {

    private lateinit var source: PetSource

    private val api = mockk<DiscoveryPetService>()

    @Before
    fun setup() {
        source = PetSource(api)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `WHEN api is called to get pets list THEN should call api resource`() =
        runBlockingTest {
            coEvery { api.getPets(any(), any()) } returns petResponse

            source.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 1,
                    placeholdersEnabled = true
                )
            )
            coVerify(exactly = 1) { api.getPets(1, 10) }
        }

    @Test
    fun `WHEN main network call returns error THEN should return error page`() = runBlockingTest {
        coEvery { api.getPets(any(), any()) } throws Exception()

        assertTrue(
            source.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 2,
                    placeholdersEnabled = false
                )
            ) is PagingSource.LoadResult.Error
        )
    }

    @Test
    fun `WHEN api contains more then zero results THEN should call detail response correctly`() =
        runBlockingTest {
            coEvery { api.getPets(any(), any()) } returns petResponse

            source.load(
                PagingSource.LoadParams.Refresh(
                    key = 1,
                    loadSize = 1,
                    placeholdersEnabled = true
                )
            )

            coVerify(exactly = 1) { api.getPets(1, 10) }
        }

    @Test
    fun `WHEN api returns success data THEN should inform correctly`() =
        runBlockingTest {
            coEvery { api.getPets(any(), any()) } returns petResponse

            val result = source.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 2,
                    placeholdersEnabled = false
                )
            ) as PagingSource.LoadResult.Page

            assertTrue(result.data.containsAll(petResponse.data))
        }
}