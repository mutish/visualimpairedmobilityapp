package com.example.models.settings

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class setting (
    val SettingsID: Int,
    val UsersID: Int,
    val audioGuidance: Boolean,
    val hapticFeedback: Boolean,
    val alertNotification: Boolean,
    val highContrast: Boolean,
    @Contextual val created_at: LocalDateTime = LocalDateTime.now(),
    @Contextual val updated_at: LocalDateTime = LocalDateTime.now(),
)


