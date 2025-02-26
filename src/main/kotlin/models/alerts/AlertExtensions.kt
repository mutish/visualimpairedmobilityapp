package com.example.models.alerts

import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toAlert() = alert(
    AlertId = this[Alerts.alertID],
    Alert_type = this[Alerts.alertType],
    Alert_description = this[Alerts.alertDescription],
    latitude = this[Alerts.latitude],
    longitude = this[Alerts.longitude],
    created_at = this[Alerts.created_at]
)