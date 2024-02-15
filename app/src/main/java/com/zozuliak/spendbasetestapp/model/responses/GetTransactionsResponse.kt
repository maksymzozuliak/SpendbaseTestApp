package com.zozuliak.spendbasetestapp.model.responses

import com.zozuliak.spendbasetestapp.model.Transaction
import kotlinx.serialization.Serializable

@Serializable
data class GetTransactionsResponse(
    val transactions: List<Transaction>
)
