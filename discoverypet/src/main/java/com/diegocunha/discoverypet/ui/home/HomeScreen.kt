package com.diegocunha.discoverypet.ui.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.diegocunha.coreui.components.SwipeCard
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen() {
    val viewModel = koinViewModel<HomeViewModel>()
    val response = viewModel.pagingFlow.collectAsLazyPagingItems()

    LazyColumn {
        items(response.itemCount) { index ->
            SwipeCard {

            }
        }

        response.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item {
                        Text("Loading")
                    }
                }
            }
        }
    }
}