package com.example.models.settings

import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toSetting() = setting(
    SettingsID = this[settingsTable.Settings_ID],
    UsersID = this[settingsTable.UsersID],
    audioGuidance = this[settingsTable.Audio_guidance],
    hapticFeedback = this[settingsTable.Haptic_feedback],
    alertNotification = this[settingsTable.Alert_notification],
    highContrast = this[settingsTable.highcontrast],
    created_at = this[settingsTable.created_at],
    updated_at = this[settingsTable.updated_at],

)