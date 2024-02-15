package com.zozuliak.spendbasetestapp.ui.main_screen.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zozuliak.spendbasetestapp.R
import com.zozuliak.spendbasetestapp.model.Card
import com.zozuliak.spendbasetestapp.model.Transaction
import com.zozuliak.spendbasetestapp.ui.theme.Green500
import com.zozuliak.spendbasetestapp.ui.theme.Neutral0
import com.zozuliak.spendbasetestapp.ui.theme.Neutral50
import com.zozuliak.spendbasetestapp.ui.theme.Neutral500
import com.zozuliak.spendbasetestapp.ui.theme.Neutral800
import com.zozuliak.spendbasetestapp.ui.theme.Neutral900

@Composable
fun TransactionItem(
    modifier: Modifier = Modifier,
    transaction: Transaction,
    nameTextStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    showCard: Boolean = true
) {

    val isLoad: Boolean = transaction.amount > 0

    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = Neutral50,
                        shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .padding(8.dp),
                    painter = painterResource(id =
                        if (isLoad) R.drawable.ic_arrow_down_left else R.drawable.ic_credit_card
                    ),
                    contentDescription = "Transaction",
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp),
            ) {
                Text(
                    modifier = Modifier,
                    text = transaction.merchant.name?: transaction.type,
                    style = nameTextStyle
                )
                if (showCard && transaction.card != null) {
                    Text(
                        modifier = Modifier,
                        text = "•• " + transaction.card.cardLast4,
                        style = TextStyle(
                            fontFamily = FontFamily.Default,
                            fontWeight = FontWeight.Medium,
                            fontSize = 12.sp,
                            color = Neutral500
                        ),
                    )
                }
            }
            Text(
                modifier = Modifier
                    .padding(start = 12.dp),
                text = transaction.amount.toString() + "$",
                style = nameTextStyle.copy(
                    color = if (isLoad) Green500 else Neutral800
                )
            )
            Icon(
                modifier = Modifier
                    .padding(start = 12.dp),
                painter = painterResource(if (transaction.attachments.isEmpty()) R.drawable.ic_without_attachments else R.drawable.ic_has_attachments ),
                contentDescription = "Attachments",
                tint = Color.Unspecified
            )
        }
    }
}