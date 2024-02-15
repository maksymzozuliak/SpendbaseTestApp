package com.zozuliak.spendbasetestapp.ui.card_screen.elements

import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zozuliak.spendbasetestapp.model.Transaction
import com.zozuliak.spendbasetestapp.ui.main_screen.elements.TransactionItem
import com.zozuliak.spendbasetestapp.ui.theme.Neutral200
import com.zozuliak.spendbasetestapp.ui.theme.Neutral500
import kotlinx.datetime.Instant
import kotlinx.datetime.toJavaInstant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@Composable
fun TransactionHistoryItem(
    modifier: Modifier = Modifier,
    date: Instant,
    dateTextStyle: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Neutral500
    ),
    transactionList: List<Transaction>
) {

    val localDate = LocalDateTime.ofInstant(date.toJavaInstant(), ZoneOffset.UTC)
    val formatter = DateTimeFormatter.ofPattern("MMM dd")

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier,
            text = localDate.format(formatter),
            style = dateTextStyle,
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            thickness = 1.dp,
            color = Neutral200
        )
        transactionList.forEach {
            TransactionItem(
                transaction = it,
                showCard = false
            )
        }
    }
}