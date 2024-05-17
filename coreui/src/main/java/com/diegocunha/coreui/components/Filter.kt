package com.diegocunha.coreui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import com.diegocunha.coreui.theme.PetsTheme

@Composable
fun FilterList(
    modifier: Modifier = Modifier,
    options: List<FilterItem>,
    isMultiple: Boolean = false,
    onClick: (List<FilterItem>) -> Unit
) {
    require(options.isNotEmpty())

    var itemsList by remember {
        mutableStateOf(
            options
        )
    }

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(itemsList.size) { index ->
            FilterOption(
                title = itemsList[index].title,
                state = getFilterState(
                    isEnabled = itemsList[index].isEnabled,
                    isSelected = itemsList[index].selected
                ),
                onClick = {
                    itemsList = updateListItem(isMultiple, itemsList, index)
                    onClick(itemsList)
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
    state: FilterState,
    leftContent: @Composable (RowScope.() -> Unit)? = null,
    rightContent: @Composable (RowScope.() -> Unit)? = null,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .clipToBounds()
            .testTag(title)
            .wrapContentHeight()
            .clickable(state.isEnabled, onClick = { onClick.invoke() })
            .clip(RoundedCornerShape(PetsTheme.sizes.spacing.x400))
            .background(color = state.backgroundColor)
            .border(
                width = PetsTheme.sizes.border.x400,
                color = state.borderColor,
                shape = RoundedCornerShape(PetsTheme.sizes.radius.x400)
            )

    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            val leftSpace = if (leftContent != null) {
                PetsTheme.sizes.spacing.x300
            } else {
                PetsTheme.sizes.spacing.x400
            }

            Spacer(modifier = Modifier.width(leftSpace))

            leftContent?.let {
                it.invoke(this)
                Spacer(modifier = Modifier.width(PetsTheme.sizes.spacing.x300))
            }

            Text(
                modifier = Modifier.padding(PetsTheme.sizes.spacing.x150),
                style = PetsTheme.typography.p4,
                color = state.textColor,
                text = title
            )

            val rightSpace = if (rightContent != null) {
                PetsTheme.sizes.spacing.x300
            } else {
                PetsTheme.sizes.spacing.x400
            }

            Spacer(modifier = Modifier.width(rightSpace))

            rightContent?.let {
                it.invoke(this)
                Spacer(modifier = Modifier.width(PetsTheme.sizes.spacing.x400))
            }
        }
    }
}

@Composable
private fun getFilterState(isEnabled: Boolean, isSelected: Boolean): FilterState {
    return when {
        !isEnabled -> FilterState.Disabled()
        isSelected -> FilterState.Active()
        else -> FilterState.Default()
    }
}

@Immutable
data class FilterState(
    val backgroundColor: Color,
    val tintColor: Color,
    val textColor: Color,
    val borderColor: Color,
    val isEnabled: Boolean = true,
) {

    companion object {

        @Stable
        @Composable
        fun Default() = FilterState(
            borderColor = PetsTheme.colors.onSecondaryContainer,
            backgroundColor = PetsTheme.colors.inversePrimary,
            textColor = PetsTheme.colors.secondary,
            tintColor = PetsTheme.colors.secondary,
        )

        @Stable
        @Composable
        fun Hover() = FilterState(
            borderColor = PetsTheme.colors.onSecondaryContainer,
            backgroundColor = PetsTheme.colors.inversePrimary,
            textColor = PetsTheme.colors.secondary,
            tintColor = PetsTheme.colors.secondary,
        )

        @Stable
        @Composable
        fun Active() = FilterState(
            borderColor = PetsTheme.colors.onSecondaryContainer,
            backgroundColor = PetsTheme.colors.inversePrimary,
            textColor = PetsTheme.colors.secondary,
            tintColor = PetsTheme.colors.secondary,
        )

        @Stable
        @Composable
        fun Disabled() = FilterState(
            borderColor = PetsTheme.colors.onSecondaryContainer,
            backgroundColor = PetsTheme.colors.inversePrimary,
            textColor = PetsTheme.colors.secondary,
            tintColor = PetsTheme.colors.secondary,
            isEnabled = false
        )
    }
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
    val selected: Boolean = false,
    val isEnabled: Boolean = true
)