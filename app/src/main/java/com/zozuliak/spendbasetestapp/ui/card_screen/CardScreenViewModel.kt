package com.zozuliak.spendbasetestapp.ui.card_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zozuliak.spendbasetestapp.model.Card
import com.zozuliak.spendbasetestapp.model.CardRepository
import com.zozuliak.spendbasetestapp.model.Transaction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.datetime.Instant
import kotlinx.serialization.json.Json
import javax.inject.Inject

@HiltViewModel
class CardScreenViewModel @Inject constructor(
    private val cardRepository: CardRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _hasError = mutableStateOf<Boolean>(false)
    val hasError: State<Boolean> = _hasError

    private val _card = mutableStateOf<Card?>(null)
    val card: State<Card?> = _card

    private val _transactionsList = mutableStateOf(listOf<TransactionHistoryItem>())
    val transactionsList: State<List<TransactionHistoryItem>> = _transactionsList

    init {
        savedStateHandle.get<String>("card")?.let { cardAsJson ->
            if (cardAsJson != "noCard") {
                try {
                    val decodedCard = Json.decodeFromString(Card.serializer(), cardAsJson)
                    _card.value = decodedCard
                    viewModelScope.launch {
                        _transactionsList.value = cardRepository.getTransactions()
                            .filter { it.card?.id == decodedCard.id }
                            .sortedBy { it.completeDate?:it.createDate }
                            .groupBy(
                                keySelector = { it.completeDate?: it.createDate },
                                valueTransform = { it }
                            )
                            .map { (instant, data) ->
                                TransactionHistoryItem(instant, data)
                            }
                        // assuming we have specific request
                    }
                } catch (e: Exception) {
                    _hasError.value = true
                }
            }
        }
    }
}

data class TransactionHistoryItem(
    val instant: Instant,
    val data: List<Transaction>
)