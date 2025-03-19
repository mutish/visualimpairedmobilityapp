package com.example.database

import com.example.models.Users
import com.example.models.alerts.Alerts
import com.example.models.econtacts.emergency_contacts
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        val url = "jdbc:mysql://localhost:3306/tembeanami"
        val driver = "com.mysql.cj.jdbc.Driver"
        val user = "root"
        val password = "20700817Mkrs!"

        Database.connect(url, driver, user, password)

        transaction {
            SchemaUtils.create(
                Users,
                Alerts,
                //Navigation_history,
                emergency_contacts
            ) //creation of tables
        }
    }
}