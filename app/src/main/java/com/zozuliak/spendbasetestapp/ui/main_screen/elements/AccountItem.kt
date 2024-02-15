package com.zozuliak.spendbasetestapp.ui.main_screen.elements

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.unit.dp
import com.zozuliak.spendbasetestapp.R

@Composable
fun AccountItem(
    modifier: Modifier = Modifier,
    @DrawableRes flag: Int,
    name: String,
    nameTextStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    amount: String,
    amountTextStyle: TextStyle = MaterialTheme.typography.titleLarge,
) {

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .padding(end = 8.dp),
                    painter = painterResource(id = R.drawable.ic_usa_flag),
                    contentDescription = "FlagIcon",
                    tint = Color.Unspecified
                )
                Text(
                    text = name,
                    style = nameTextStyle
                )
            }
            Text(
                text = amount,
                style = amountTextStyle
            )
        }
    }
}