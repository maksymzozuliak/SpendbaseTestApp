package com.zozuliak.spendbasetestapp.ui.card_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.zozuliak.spendbasetestapp.R
import com.zozuliak.spendbasetestapp.model.Transaction
import com.zozuliak.spendbasetestapp.ui.card_screen.elements.CardButtonsPanel
import com.zozuliak.spendbasetestapp.ui.card_screen.elements.TransactionHistoryItem
import com.zozuliak.spendbasetestapp.ui.main_screen.MainScreenViewModel
import com.zozuliak.spendbasetestapp.ui.main_screen.elements.TransactionItem
import com.zozuliak.spendbasetestapp.ui.theme.Neutral200
import com.zozuliak.spendbasetestapp.ui.theme.Neutral500
import kotlinx.datetime.Instant

@Composable
fun CardScreen(
    navController: NavController,
    viewModel: CardScreenViewModel = hiltViewModel<CardScreenViewModel>(),
) {

    val scrollState = rememberScrollState()

    val card = viewModel.card.value

    val transactions = viewModel.transactionsList.value

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .heightIn(0.dp, 3000.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    modifier = Modifier,
                    painter = painterResource(R.drawable.ic_arrow_left),
                    contentDescription = "BackIcon"
                )
            }
            Row(
                modifier = Modifier
                    .weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .padding(end = 16.dp),
                    text = card?.cardName ?: "-",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    modifier = Modifier,
                    text = "•• " + (card?.cardLast4 ?: "-"),
                    style = TextStyle(
                        fontFamily = FontFamily.Default,

                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = Neutral500
                    ),
                )
            }
            Spacer(modifier = Modifier.width(48.dp))
        }
        Icon(
            modifier = Modifier
                .shadow(
                    elevation = 28.dp,
                ),
            painter = painterResource(R.drawable.card),
            contentDescription = "Card",
            tint = Color.Unspecified
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            color = Neutral200,
            thickness = 1.dp
        )
        CardButtonsPanel(
            modifier = Modifier
                .padding(top = 16.dp)
                .width(256.dp)
        )
        Card(
            modifier = Modifier
                .padding(16.dp)
                .padding(top = 8.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 54.dp),
                    text = "Activity",
                    style = MaterialTheme.typography.labelMedium,
                )
                LazyColumn(
                    modifier = Modifier
                ) {

                    items(
                        items = transactions,
                        key = { it: TransactionHistoryItem ->
                            it.instant.hashCode()
                        }
                    ) {  it: TransactionHistoryItem ->

                        TransactionHistoryItem(
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .padding(bottom = 8.dp),
                            date = it.instant,
                            transactionList = it.data
                        )
                    }
                }
            }
        }

    }
}