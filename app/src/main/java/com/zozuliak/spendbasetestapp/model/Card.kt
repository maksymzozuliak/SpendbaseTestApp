package com.zozuliak.spendbasetestapp.model

import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer
import java.util.Date

@Serializable
data class Card(
    val cardHolder: CardHolder,
    val cardLast4: String,
    val cardName: String,
    val fundingSource: String,
    val id: String,
    val isLocked: Boolean,
    val isTerminated: Boolean,
    val issuedAt: Instant,
    val limit: Int,
    val limitType: String,
    val spent: Int
)