package com.zozuliak.spendbasetestapp.ui.main_screen

import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zozuliak.spendbasetestapp.model.Card
import com.zozuliak.spendbasetestapp.model.CardRepository
import com.zozuliak.spendbasetestapp.model.Transaction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val cardRepository: CardRepository
) : ViewModel() {

    private val _cardList = mutableStateOf(listOf<Card>())
    val cardList: State<List<Card>> = _cardList

    private val _transactionsList = mutableStateOf(listOf<Transaction>())
    val transactionsList: State<List<Transaction>> = _transactionsList

    init {

        viewModelScope.launch {
            _cardList.value = cardRepository.getCards()
            _transactionsList.value = cardRepository.getTransactions().sortedBy { it.completeDate?:it.createDate }.take(3)
        }
    }

}