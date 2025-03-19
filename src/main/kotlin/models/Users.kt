package com.example.models


import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.CurrentTimestamp
import org.jetbrains.exposed.sql.javatime.datetime


object Users : Table("users") {

    val UsersID = integer("UsersID").autoIncrement()
    val Username = varchar("Username", 40)
    val Email = varchar("Email", 40)
    val FirebaseUUID = varchar("FirebaseUUID", 255)

    override val primaryKey = PrimaryKey(UsersID)
}