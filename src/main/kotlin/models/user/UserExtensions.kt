package com.example.models.user

import com.example.models.Users
import org.jetbrains.exposed.sql.ResultRow
fun ResultRow.toUser() = User(
    UsersID = this[Users.UsersID],
    Username = this[Users.Username],
    Email = this[Users.Email],
    FirebaseUUID = this[Users.FirebaseUUID],

)


