package com.diegocunha.discoverypet.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.diegocunha.coreui.components.FilterItem
import com.diegocunha.coreui.components.FilterList
import com.diegocunha.discoverypet.ui.PetCardBox
import org.koin.androidx.compose.koinViewModel

private const val COLUMN_COUNT = 2
private val GRID_SPACING = 8.dp

@Composable
fun HomeScreen() {
    val viewModel = koinViewModel<HomeViewModel>()
    val lazyListState = rememberLazyGridState()
    val response = viewModel.pagingFlow.collectAsLazyPagingItems()

    Column {
        FilterList(options = listOf(FilterItem("Text"))) {

        }

        LazyVerticalGrid(
            state = lazyListState,
            columns = GridCells.Fixed(COLUMN_COUNT),
            horizontalArrangement = Arrangement.spacedBy(
                GRID_SPACING,
                Alignment.CenterHorizontally
            ),
            contentPadding = PaddingValues(
                start = GRID_SPACING,
                end = GRID_SPACING,
                bottom = 4.dp
            ),
            content = {
                items(response.itemCount) { index ->
                    val pet = response.peek(index) ?: return@items
                    PetCardBox(pet = pet)
                }
            }
        )
    }
}