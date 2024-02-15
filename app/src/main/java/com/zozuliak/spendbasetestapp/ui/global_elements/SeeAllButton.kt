package com.zozuliak.spendbasetestapp.ui.global_elements

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun SeeAllButton(
    onClick: () -> Unit,
    text: String = "See All",
    textStyle: TextStyle = MaterialTheme.typography.bodySmall,
) {
    Text(
        modifier = Modifier.clickable { onClick() },
        text = text,
        style = textStyle,
        textDecoration = TextDecoration.Underline
    )
}