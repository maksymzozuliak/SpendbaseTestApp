package com.zozuliak.spendbasetestapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Merchant(
    val icon: String?,
    val name: String?
)