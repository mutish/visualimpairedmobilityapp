package com.example.repository

import com.example.models.User
import com.example.models.Users
import com.example.models.toUser
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

// Handles CRUD operations for Users
class UserRepository {

    // Fetch all users
    fun getAllUsers(): List<User> = transaction {
        Users.selectAll().map { it.toUser() }
    }

    // Fetch a user by ID
    fun getUserById(UserID: Int): User? = transaction {
        Users.selectAll().where { Users.UsersID eq UserID }
            .map { it.toUser() }
            .singleOrNull()
    }

    // Insert a new user
    fun newUser(username: String, email: String, telNo: String, password: String, profilePicture: String): Int? {
        return transaction {
            Users.insert {
                it[Username] = username
                it[Email] = email
                it[Telno] = telNo
                it[Password_hash] = password
                it[Profile_picture] = profilePicture
            } get Users.UsersID // Retrieve inserted UsersID
        }
    }
    //update user
    fun updateUser(UserID: Int, user: User): Boolean = transaction {
        Users.update({Users.UsersID eq UserID}){
            it[Username] = user.Username
            it[Email] =user.Email
            it[Telno] =user.TelNo
            it[Password_hash] =user.Password_hash
            it[Profile_picture] =user.Profile_picture
            it[updated_at] =user.updatedAt
        } > 0
    }
    //delete user
    fun deleteUser(UserID: Int): Boolean = transaction{
        Users.deleteWhere { Users.UsersID eq UserID } > 0
    }
}
