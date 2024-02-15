package com.zozuliak.spendbasetestapp.ui.global_elements

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zozuliak.spendbasetestapp.R
import com.zozuliak.spendbasetestapp.ui.theme.Neutral200

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = MaterialTheme.typography.titleLarge,
    @DrawableRes leftIconResId: Int?,
    @DrawableRes rightIconResId: Int?,
    dividerColor: Color = Neutral200
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = titleStyle
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            if (leftIconResId != null) {
                Icon(
                    modifier = Modifier
                        .padding(12.dp),
                    painter = painterResource(id = leftIconResId),
                    contentDescription = "TopBarIcon"
                )
            }
            if (rightIconResId != null) {
                Icon(
                    modifier = Modifier
                        .padding(12.dp),
                    painter = painterResource(rightIconResId),
                    contentDescription = "TopBarIcon"
                )
            }
        }
        Divider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = dividerColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar(
        title = "Money",
        leftIconResId = R.drawable.ic_plus,
        rightIconResId = R.drawable.ic_bank
    )
}