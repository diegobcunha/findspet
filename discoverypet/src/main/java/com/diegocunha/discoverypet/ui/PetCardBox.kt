package com.diegocunha.discoverypet.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ChipColors
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.diegocunha.coreui.components.CardBox
import com.diegocunha.coreui.components.ImageLoader
import com.diegocunha.coreui.components.StatusChip
import com.diegocunha.coreui.theme.PetsTheme
import com.diegocunha.coreui.tokens.colors.overImage
import com.diegocunha.discoverypet.ui.home.PetUi
import com.diegocunha.discoverypet.ui.home.PetUiStatus

private val GRID_SPACING = 8.dp

@Composable
fun PetCardBox(
    modifier: Modifier = Modifier,
    pet: PetUi
) {
    CardBox(
        modifier = modifier
            .height(360.dp)
            .padding(vertical = GRID_SPACING),
        onClick = {},
    ) {
        Box {
            ImageLoader(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxSize(),
                painter = rememberAsyncImagePainter(
                    model = pet.image
                ),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(4.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(overImage)
                    .padding(horizontal = 6.dp, vertical = 4.dp)
            ) {
                Text(
                    text = pet.city,
                    style = PetsTheme.typography.h3,
                    color = Color.White,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )

                StatusChip(text = pet.status.name, colors = pet.status.colorScheme())
            }
        }
    }
}

@Composable
fun PetUiStatus.colorScheme(): ChipColors {
    return when (this) {
        PetUiStatus.MISSED -> SuggestionChipDefaults.suggestionChipColors(
            containerColor = PetsTheme.colors.errorContainer
        )

        PetUiStatus.SEARCH -> SuggestionChipDefaults.suggestionChipColors(
            containerColor = PetsTheme.colors.inverseSurface
        )
    }
}