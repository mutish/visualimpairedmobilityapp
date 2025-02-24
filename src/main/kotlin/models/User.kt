package com.example.models


import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable

data class User(
    val UserID: Int? = null,
    val Username: String,
    val Email: String,
    val TelNo: String,
    val Password_hash: String,
    val Profile_picture: String,
    @Contextual val createdAt: LocalDateTime = LocalDateTime.now(),
    @Contextual val updatedAt: LocalDateTime = LocalDateTime.now()

    )