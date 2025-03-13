package com.example.models.user

import com.example.models.Users
import org.jetbrains.exposed.sql.ResultRow
fun ResultRow.toUser() = User(
    UsersID = this[Users.UsersID],
    Username = this[Users.Username],
    Email = this[Users.Email],
    TelNo = this[Users.Telno],
    Profile_picture = this[Users.Profile_picture],
    createdAt = this[Users.created_at],
    updatedAt = this[Users.updated_at]
)


