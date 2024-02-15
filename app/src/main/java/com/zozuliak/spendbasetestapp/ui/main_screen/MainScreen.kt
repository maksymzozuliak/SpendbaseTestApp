package com.zozuliak.spendbasetestapp.ui.main_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.zozuliak.spendbasetestapp.R
import com.zozuliak.spendbasetestapp.model.Card
import com.zozuliak.spendbasetestapp.ui.global_elements.TopBar
import com.zozuliak.spendbasetestapp.ui.main_screen.elements.AccountItem
import com.zozuliak.spendbasetestapp.ui.main_screen.elements.MyCardsItem
import com.zozuliak.spendbasetestapp.ui.main_screen.elements.RecentTransactionsItem
import com.zozuliak.spendbasetestapp.ui.main_screen.elements.TransactionItem
import com.zozuliak.spendbasetestapp.utils.Screen
import kotlinx.serialization.json.Json

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainScreenViewModel = hiltViewModel<MainScreenViewModel>(),
) {

    val cardList = viewModel.cardList.value
    val transactionList = viewModel.transactionsList.value
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
            .heightIn(0.dp, 3000.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {

        TopBar(
            modifier = Modifier.padding(horizontal = 16.dp).padding(top = 8.dp),
            title = "Money",
            leftIconResId = R.drawable.ic_plus,
            rightIconResId = R.drawable.ic_bank
        )
        AccountItem(
            modifier = Modifier.padding(horizontal = 16.dp).padding(top = 24.dp),
            flag = R.drawable.ic_usa_flag,
            name = "USD account",
            amount = "$100,000"
        )
        MyCardsItem(
            modifier = Modifier.padding(horizontal = 16.dp).padding(top = 16.dp),
            label = "My cards",
            cards = cardList,
            onCardItemClick = {
                val cardAsJson = Json.encodeToString(Card.serializer(), it)
                navController.navigate(
                    Screen.CardScreen.route +
                            "?card=${cardAsJson}"
                )
            }
        )
        RecentTransactionsItem(
            modifier = Modifier.padding(horizontal = 16.dp).padding(top = 16.dp),
            label = "Recent transactions",
            transactions = transactionList
        )
    }

}