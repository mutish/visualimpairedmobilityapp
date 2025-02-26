package com.example.models.econtacts

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.CurrentTimestamp
import org.jetbrains.exposed.sql.javatime.datetime

object emergency_contacts: Table() {

    val EC_ID = integer("EC_ID").autoIncrement()
    val UsersID = integer("UsersID")
    val Contact_name = varchar("Contact_name", 45)
    val Contact_phone = varchar("Contact_phone", 12)
    val relationship = varchar("Relationship", 10)
    val createdat = datetime("created_at").defaultExpression(CurrentTimestamp())

    override val primaryKey = PrimaryKey(EC_ID)
}