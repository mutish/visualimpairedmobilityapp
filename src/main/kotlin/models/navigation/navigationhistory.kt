package com.example.models.navigation

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDateTime


data class navigation_history(
    val NavID: Int,
    val UsersID: Int? = null,
    val start_location: String,
    val end_location: String,
    val travel_mode: String,
    val created_at: LocalDateTime = LocalDateTime.now()

)