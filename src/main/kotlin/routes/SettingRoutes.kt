package com.example.routes

import com.example.repository.settingrepository
import com.example.models.settings.setting
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.http.*

fun Application.settingRoutes() {
    val settingsRepo = settingrepository()

    routing {
        // Get user settings
        get("/settings/{userID}") {
            val userID = call.parameters["userID"]?.toIntOrNull()
            if (userID == null) {
                call.respond(HttpStatusCode.BadRequest, "Invalid user ID")
                return@get
            }

            val settings = settingsRepo.getUserSettings(userID)
            if (settings != null) {
                call.respond(settings)
            } else {
                call.respond(HttpStatusCode.NotFound, "Settings not found for this user")
            }
        }

        // Update user settings
        put("/settings/{userID}") {
            val userID = call.parameters["userID"]?.toIntOrNull()
            if (userID == null) {
                call.respond(HttpStatusCode.BadRequest, "Invalid user ID")
                return@put
            }

            val newSettings = call.receive<setting>()
            val success = settingsRepo.updateUserSetting(userID, newSettings)

            if (success) {
                call.respond(HttpStatusCode.OK, "Settings updated successfully")
            } else {
                call.respond(HttpStatusCode.InternalServerError, "Failed to update settings")
            }
        }

        // Reset user settings
        post("/settings/{userID}/reset") {
            val userID = call.parameters["userID"]?.toIntOrNull()
            if (userID == null) {
                call.respond(HttpStatusCode.BadRequest, "Invalid user ID")
                return@post
            }

            val success = settingsRepo.resetUserSetting(userID)
            if (success) {
                call.respond(HttpStatusCode.OK, "Settings reset to default")
            } else {
                call.respond(HttpStatusCode.InternalServerError, "Failed to reset settings")
            }
        }
    }
}
