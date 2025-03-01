package com.example.models.alerts

import java.math.BigDecimal
import java.time.LocalDateTime

data class alert(
    val AlertId: Int,
    val Alert_type: String,
    val Alert_description: String,
    val latitude: BigDecimal,
    val longitude: BigDecimal,
    val created_at: LocalDateTime = LocalDateTime.now(),
)
