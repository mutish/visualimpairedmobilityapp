package com.example.models


import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.CurrentTimestamp
import org.jetbrains.exposed.sql.javatime.datetime


object Users : Table("users") {
    val UsersID = integer("UsersID").autoIncrement()
    val Username = text("Username").uniqueIndex() // Ensuring it is non-null
    val Email = text("Email")
    val FirebaseUUID = varchar("FirebaseUUID", 255)
    val createdAt = datetime("created_at").defaultExpression(CurrentTimestamp())

    override val primaryKey = PrimaryKey(UsersID)
}
