package com.zozuliak.spendbasetestapp.model

interface CardRepository {

    suspend fun getCards() : List<Card>

    suspend fun getTransactions() : List<Transaction>
}