package com.example.models.sosrequest

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.CurrentTimestamp
import org.jetbrains.exposed.sql.javatime.datetime

object sos_requests: Table() {
    val SOS_ID= integer("SOS_ID").autoIncrement()
    val UsersID= integer("UsersID")
    val SOS_Status = varchar("SOS_Status",10).default("Pending")
    val latitude = decimal("latitude",9,6)
    val longitude = decimal("longitude",9,6)
    val ntime = datetime("ntime").defaultExpression(CurrentTimestamp())
    val recipient = integer("recipient")

}