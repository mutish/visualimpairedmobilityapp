package com.example.models.sosrequest

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
@Serializable
data class sos_request (
    val SOS_ID: Int,
    val UsersID: Int,
    val SOS_Status: String,
    val latitude: Double,
    val longitude: Double,
    @Contextual val ntime: LocalDateTime = LocalDateTime.now(),
    val recipient: Int
)
