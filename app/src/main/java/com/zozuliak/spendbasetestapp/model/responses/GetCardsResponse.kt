package com.zozuliak.spendbasetestapp.model.responses

import com.zozuliak.spendbasetestapp.model.Card
import kotlinx.serialization.Serializable

@Serializable
data class GetCardsResponse(
    val cards: List<Card>
)