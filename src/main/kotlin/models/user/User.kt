package com.example.models.user


import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDateTime



data class User(
    val UsersID: Int,
    val Username: String,
    val Email: String,
    val TelNo: String,
    val Password_hash: String,
    val Profile_picture: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()

    )