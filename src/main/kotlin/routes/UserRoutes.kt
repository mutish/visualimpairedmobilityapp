package com.example.routes

import com.example.models.user.User
import com.example.repository.UserRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// define user endpoints
fun Application.userRoutes(){
    val userRepository = UserRepository()
    routing {
        //Get all users
        get("/users") {
        call.respond(userRepository.getAllUsers())
        }

        //by ID
        get("/users/{UserID}") {
            val UsersID = call.parameters["UserID"]?.toIntOrNull()
            if (UsersID == null) {
              call.respond("Invalid user ID")
              return@get
            }
            val user = userRepository.getUserById(UsersID)
            if (user != null) call.respond(user) else call.respond("User not found")
        }




        //create user
        post("/users") {
            val user = call.receive<User>()
            val newUserID = userRepository.newUser(
                firebaseId = user.FirebaseUUID,
                username = user.Username,
                email = user.Email
            )
            if (newUserID != null) {
                call.respond("User created successfully.")
            } else {
                call.respond("Failed to create user")
            }
        }
        //update user
        put("/users/{UserID}") {
            val UserID = call.parameters["UserID"]?.toIntOrNull()
            if (UserID == null) {
                call.respond("Invalid user ID")
                return@put
            }
            val user = call.receive<User>()
            val updated = userRepository.updateUser(UserID, user)
            call.respond(if (updated) "User updated successfully" else "User Update failed. Try Again")
        }

        //delete
        delete("/users/{UserID}") {
            val UserID = call.parameters["UserID"]?.toIntOrNull()
            if (UserID == null) {
                call.respond(HttpStatusCode.Unauthorized,"Invalid user ID")
                return@delete
            }
            val deleted = userRepository.deleteUser(UserID)
            call.respond(if (deleted) "User deleted successfully" else "User not found")
        }
    }
}
