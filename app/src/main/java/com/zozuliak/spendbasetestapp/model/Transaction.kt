package com.zozuliak.spendbasetestapp.model

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Transaction(
    val account: Account,
    val amount: Double,
    val attachments: List<Attachment>,
    val card: Card?,
    val category: String?,
    val completeDate: Instant?,
    val createDate: Instant,
    val id: String,
    val merchant: Merchant,
    val origin: String,
    val publicId: String,
    val status: String,
    val type: String
)