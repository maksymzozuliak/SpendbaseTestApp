package com.zozuliak.spendbasetestapp.model

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Attachment(
    val createdAt: Instant,
    val deletedAt: Instant?,
    val externalTransactionId: String,
    val fileName: String,
    val fileSize: String,
    val fileType: String,
    val fileUrl: String,
    val id: String,
    val note: String,
    val sourceId: String,
    val transactionId: String,
    val updatedAt: Instant
)