package com.example.routes

import com.example.models.sosrequest.sos_request
import com.example.repository.sosrepository
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.sosRoutes() {
    val sosrepo = sosrepository()
    routing {
        //all requests
        get("/sos") {
            call.respond(sosrepo.getAllRequests())
        }
        //create sos
        post("/sos") {
            val sos = call.receive<sos_request>()
            val sosID = sosrepo.createSOS(
                usersID = sos.UsersID,
                lat = sos.latitude,
                long = sos.longitude,
            )
            if (sosID != null) {
                call.respond("SOS sent successfully ")
            } else {
                call.respond("SOS failed!!")
            }
        }
        //update SOS Status
        put("/sos/{SOSID}") {
            val sosID = call.parameters["SOSID"]?.toIntOrNull()
            if (sosID == null) {
                call.respond("Error!!")
                return@put
            }
            val newstatus = call.receive<sos_request>()
            val updated = sosrepo.updateSOS(sosID, newstatus.SOS_Status)
            call.respond(if (updated) "Success" else "Failed")
        }

        //filter by ID
        get("/sos/{SOSID}") {
            val sosID = call.parameters["SOSID"]?.toIntOrNull()
            if (sosID == null) {
                call.respond("Error!!")
                return@get
            }
            val sos = sosrepo.getSOSbyID(sosID)
            if (sos != null) call.respond(sos) else call.respond("SOS not found!!")
        }

    }
}