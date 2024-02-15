package com.zozuliak.spendbasetestapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    val accountLast4: String,
    val accountName: String,
    val accountType: String
)