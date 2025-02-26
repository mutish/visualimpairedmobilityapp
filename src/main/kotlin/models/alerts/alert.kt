package com.example.models.alerts

import java.time.LocalDateTime

data class alert(
    val AlertId: Int,
    val Alert_type: String,
    val Alert_description: String,
    val latitude: Double,
    val longitude: Double,
    val created_at: LocalDateTime = LocalDateTime.now(),
)
