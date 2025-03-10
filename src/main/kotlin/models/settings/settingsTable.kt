package com.example.models.settings

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.CurrentTimestamp
import org.jetbrains.exposed.sql.javatime.datetime

object settingsTable: Table("settings") {

    val Settings_ID =  integer("Settings_ID").autoIncrement()
    val UsersID = integer("UsersID")
    val Audio_guidance = bool("Audio_guidance")
    val Haptic_feedback = bool("Haptic_feedback")
    val Alert_notification = bool("Alert_notification")
    val highcontrast = bool("highcontrast")
    val created_at = datetime("created_at").defaultExpression(CurrentTimestamp())
    val updated_at = datetime("updated_at").defaultExpression(CurrentTimestamp())

    override val primaryKey = PrimaryKey(Settings_ID)
}