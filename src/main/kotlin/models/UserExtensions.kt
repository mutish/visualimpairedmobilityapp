package com.example.models

import org.jetbrains.exposed.sql.ResultRow
fun ResultRow.toUser() = User(
    UserID = this[Users.UsersID],
    Username = this[Users.Username],
    Email = this[Users.Email],
    TelNo = this[Users.Telno],
    Password_hash = this[Users.Password_hash],
    Profile_picture = this[Users.Profile_picture],
    createdAt = this[Users.created_at],
    updatedAt = this[Users.updated_at]
)


