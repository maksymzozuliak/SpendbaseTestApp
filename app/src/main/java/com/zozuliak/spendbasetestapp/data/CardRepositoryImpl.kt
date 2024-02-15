package com.zozuliak.spendbasetestapp.data

import android.util.Log
import com.zozuliak.spendbasetestapp.model.Card
import com.zozuliak.spendbasetestapp.model.CardRepository
import com.zozuliak.spendbasetestapp.model.Transaction
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val api: ServerApi
) : CardRepository {

    override suspend fun getCards(): List<Card> {
        return try {
            val response = api.getCards()
            return if (response.isSuccessful) {
                response.body()?.cards ?: listOf()
            } else listOf()
        } catch (e: Exception) {
            listOf()
        }
    }

    override suspend fun getTransactions(): List<Transaction> {
        return try {
            val response = api.getTransactions()
            return if (response.isSuccessful) {
                response.body()?.transactions ?: listOf()
            } else listOf()
        } catch (e: Exception) {
            listOf()
        }
    }

}