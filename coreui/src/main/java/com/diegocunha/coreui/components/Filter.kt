package com.diegocunha.coreui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.diegocunha.coreui.theme.PetsTheme

@Composable
fun FilterList(
    modifier: Modifier = Modifier,
    options: List<FilterItem>,
    isMultiple: Boolean = false,
    onClick: (List<FilterItem>) -> Unit
) {
    require(options.isNotEmpty())

    var itemList by remember {
        mutableStateOf(options)
    }

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(itemList.size) { index ->
            val item = itemList[index]
            FilterOption(
                title = item.title,
                enable = item.isEnable,
                isSelected = item.selected,
                onClick = {
                    itemList = updateListItem(isMultiple, itemList, index)
                    onClick(itemList)
                }
            )

            Spacer(modifier = Modifier.width(PetsTheme.sizes.spacing.x300))
        }
    }

}

@Composable
fun FilterOption(
    modifier: Modifier = Modifier,
    title: String,
    enable: Boolean,
    isSelected: Boolean,
    onClick: () -> Unit
) {

    FilterChip(
        modifier = modifier,
        onClick = { onClick.invoke() },
        selected = isSelected,
        label = { Text(text = title) },
        leadingIcon = {
            if (isSelected) {
                Icon(
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                    imageVector = Icons.Filled.Done,
                    contentDescription = null
                )
            } else {
                null
            }
        },
        enabled = enable
    )
}

private fun updateListItem(
    isMultiple: Boolean,
    itemsRemember: List<FilterItem>,
    index: Int
): List<FilterItem> {
    return itemsRemember.mapIndexed { indexUpdated, item ->
        if (index == indexUpdated) {
            item.copy(selected = !item.selected)
        } else {
            if (isMultiple) {
                item
            } else {
                item.copy(selected = false)
            }
        }
    }
}

data class FilterItem(
    val title: String,
    val selected: Boolean,
    val isEnable: Boolean
)