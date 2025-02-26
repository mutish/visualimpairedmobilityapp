package com.example.models.alerts

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.CurrentTimestamp
import org.jetbrains.exposed.sql.javatime.datetime

object Alerts: Table() {
    val alertID = integer("Alert_ID").autoIncrement()
    val alertType = varchar("Alert_type", 40)
    val alertDescription = varchar("Alert_description", 255)
    val longitude = decimal("longitude",9,6)
    val latitude = decimal("latitude",9,6)
    val created_at = datetime("created_at").defaultExpression(CurrentTimestamp())

    override val primaryKey = PrimaryKey(alertID)
}