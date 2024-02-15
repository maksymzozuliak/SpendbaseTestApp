package com.zozuliak.spendbasetestapp.model

import kotlinx.serialization.Serializable

@Serializable
data class CardHolder(
    val email: String,
    val fullName: String,
    val id: String,
    val logoUrl: String
)