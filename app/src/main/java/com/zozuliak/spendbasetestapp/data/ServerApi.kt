package com.zozuliak.spendbasetestapp.data

import com.zozuliak.spendbasetestapp.model.Card
import com.zozuliak.spendbasetestapp.model.Transaction
import com.zozuliak.spendbasetestapp.model.responses.GetCardsResponse
import com.zozuliak.spendbasetestapp.model.responses.GetTransactionsResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ServerApi {

    @GET("/cards")
    suspend fun getCards() : Response<GetCardsResponse>

    @GET("/cards/transactions")
    suspend fun getTransactions() : Response<GetTransactionsResponse>
}