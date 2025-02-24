package com.example.models


import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.CurrentTimestamp
import org.jetbrains.exposed.sql.javatime.datetime


object Users : Table() {

    val UsersID = integer("UsersID").autoIncrement()
    val Username = varchar("Username", 40)
    val Email = varchar("Email", 25)
    val Telno = varchar("Telno", 12)
    val Password_hash = varchar("Password_hash", 255)
    val Profile_picture = varchar("Profile_picture", 255)
    val created_at = datetime("created_at").defaultExpression(CurrentTimestamp())
    val updated_at = datetime("updated_at").defaultExpression(CurrentTimestamp())

    override val primaryKey = PrimaryKey(UsersID)
}