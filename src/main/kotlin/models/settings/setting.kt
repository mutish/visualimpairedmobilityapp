package com.example.models.settings

import java.time.LocalDateTime

data class setting (
    val SettingsID: Int,
    val UsersID: Int,
    val audioGuidance: Boolean,
    val hapticFeedback: Boolean,
    val alertNotification: Boolean,
    val highContrast: Boolean,
    val created_at: LocalDateTime = LocalDateTime.now(),
    val updated_at: LocalDateTime = LocalDateTime.now(),
)


