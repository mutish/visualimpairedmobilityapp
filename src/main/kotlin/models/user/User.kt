package com.example.models.user

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class User(
    val UsersID: Int,
    val Username: String,
    val Email: String,
    val FirebaseUUID: String,
    @Serializable(with = LocalDateTimeSerializer::class)
    val createdAt: LocalDateTime,

    )