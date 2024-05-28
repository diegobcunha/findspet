package com.diegocunha.coreui.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle

@Composable
fun HyperLinkText(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    style: TextStyle,
    onLinkClicked: (String) -> Unit
) {
    ClickableText(
        modifier = modifier,
        style = style,
        text = text) { offset ->
        val result = text.getStringAnnotations(offset, offset).firstOrNull()
        result?.item?.let { onLinkClicked(it) }
    }
}