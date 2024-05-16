package com.diegocunha.discoverypet.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.diegocunha.coreui.components.CardBox
import com.diegocunha.coreui.components.ImageLoader
import com.diegocunha.coreui.theme.PetsTheme

private val GRID_SPACING = 8.dp

@Composable
fun PetCardBox(
    modifier: Modifier = Modifier,
    imageUrl: String
) {
    CardBox(
        modifier = Modifier
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
                    model = imageUrl
                ),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(4.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Perrito",
                    style = PetsTheme.typography.p5,
                    color = PetsTheme.colors.secondary,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
    }
}