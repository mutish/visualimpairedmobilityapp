package com.example.repository

import com.example.models.Users
import com.example.models.user.User
import com.example.models.user.toUser
import com.google.firebase.database.FirebaseDatabase
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.time.LocalDateTime

// Handles CRUD operations for Users
class UserRepository {
    // Insert a new user
    fun newUser(firebaseId: String, username: String, email: String,): String {
        return transaction {
            Users.insert {
                it[FirebaseUUID] = firebaseId
                it[Username] = username
                it[Email] = email

            } get Users.Username // Retrieve inserted username
        }
    }

    // Fetch all users
    fun getAllUsers(): List<User> = transaction {
        Users.selectAll().map { it.toUser() }
    }


    fun getUserById(UserID: Int): User? = transaction {
        Users.selectAll().where { Users.UsersID eq UserID }
            .map { it.toUser() }
            .singleOrNull()
    }




    //update user
    fun updateUser(UserID: Int, user: User): Boolean = transaction {
        Users.update({Users.UsersID eq UserID}){
            it[Username] = user.Username
            it[Email] =user.Email

        } > 0
    }
    //delete user
    fun deleteUser(UserID: Int): Boolean = transaction{
        Users.deleteWhere { Users.UsersID eq UserID } > 0
    }
}
