package com.example.models.navigation

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.CurrentTimestamp
import org.jetbrains.exposed.sql.javatime.datetime

object navigationHistory: Table(name = "navigation_history",
) {
    val NavID = integer("NavID").autoIncrement()
    val UsersID = integer("UsersID").autoIncrement()
    val start_location = varchar("start_location", 40)
    val end_location = varchar("end_location", 40)
    val travel_mode = varchar("travel_mode", 15)
    val created_at = datetime("created_at").defaultExpression(CurrentTimestamp())

    override val primaryKey = PrimaryKey(NavID)
}