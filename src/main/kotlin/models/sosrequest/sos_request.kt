package com.example.models.sosrequest

import java.time.LocalDateTime

data class sos_request (
    val SOS_ID: Int,
    val UsersID: Int,
    val SOS_Status: String,
    val latitude: Double,
    val longitude: Double,
    val ntime: LocalDateTime = LocalDateTime.now(),
    val recipient: Int
)
