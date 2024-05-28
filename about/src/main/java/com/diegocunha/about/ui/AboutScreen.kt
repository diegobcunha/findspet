package com.diegocunha.about.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.diegocunha.about.R
import com.diegocunha.coreui.components.HyperLinkText
import com.diegocunha.coreui.theme.PetsTheme
import com.diegocunha.coreui.utils.openLink

@Composable
fun AboutScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.padding(vertical = 8.dp),
            painter = painterResource(id = R.drawable.ic_paw),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = stringResource(id = R.string.about_title),
            style = PetsTheme.typography.h2
        )
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = stringResource(id = R.string.about_purpose),
            textAlign = TextAlign.Justify
        )

        val urlAbout = stringResource(id = R.string.about_info_site01)
        HyperLinkText(
            style = PetsTheme.typography.p3,
            text = buildAnnotatedString {
                append(stringResource(id = R.string.about_info_pt01))
                withStyle(style = SpanStyle()) {
                    pushStringAnnotation(urlAbout, urlAbout)
                    append(urlAbout)
                }
                pushStringAnnotation(
                    tag = stringResource(id = R.string.about_info_site01),
                    annotation = stringResource(id = R.string.about_info_site01)
                )
                pop()
                append(stringResource(id = R.string.about_info_pt02))
            },
        ) {
            context.openLink(it)
        }
    }
}