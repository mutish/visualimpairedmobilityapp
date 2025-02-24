package com.example.database

import com.example.UserService
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init() {
        val url = "jdbc:mysql://localhost:3306/your_database"
        val driver = "com.mysql.cj.jdbc.Driver"
        val user = "root"
        val password = "MySQL@2024"

        Database.connect(url, driver, user, password)

        transaction {
            SchemaUtils.create(UserService.Users) //creation of tables
        }
    }
}