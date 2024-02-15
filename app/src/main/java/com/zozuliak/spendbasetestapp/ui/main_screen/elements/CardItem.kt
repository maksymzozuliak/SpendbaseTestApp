package com.zozuliak.spendbasetestapp.ui.main_screen.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zozuliak.spendbasetestapp.R
import com.zozuliak.spendbasetestapp.model.Card
import com.zozuliak.spendbasetestapp.ui.theme.Neutral0
import com.zozuliak.spendbasetestapp.ui.theme.Neutral800
import com.zozuliak.spendbasetestapp.ui.theme.Neutral900

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    card: Card,
    nameTextStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier
                    .background(
                        color = Neutral800,
                        shape = RoundedCornerShape(4.dp)
                    )
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 14.dp, top = 10.dp, end = 6.dp, bottom = 4.dp),
                    text = card.cardLast4,
                    style = TextStyle(
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 10.sp,
                        color = Neutral0
                    ),
                )
            }
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp),
                text = card.cardName,
                style = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Neutral900
                ),
            )
            Icon(
                modifier = Modifier
                    .padding(4.dp),
                painter = painterResource(R.drawable.ic_arror_right),
                contentDescription = "Card"
            )
        }
    }
}