package com.example.models.user

import com.example.models.Users
import org.jetbrains.exposed.sql.ResultRow
fun ResultRow.toUser(): User {
    return User(
        UsersID = this[Users.UsersID],
        Username = this[Users.Username] ?: "UnknownUser",
        Email = this[Users.Email] ?: "",
        FirebaseUUID = this[Users.FirebaseUUID] ?: "",
        createdAt = this[Users.createdAt],
    )
}



