package com.example.routes

import com.example.repository.AlertRepository
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.alertRoutes(){
    val alertsrepo = AlertRepository()
    routing {
        get("/alerts"){
            call.respond(alertsrepo.getAllAlerts())
        }
        get("/alerts/nearby") {
            val lat = call.request.queryParameters["lat"]?.toDoubleOrNull()
            val long = call.request.queryParameters["long"]?.toDoubleOrNull()

            if (lat == null || long == null) {
                call.respond("Latitude and longitude are required")
                return@get
            }

            val nearbyAlerts = alertsrepo.getNearbyAlerts(lat, long)
            call.respond(nearbyAlerts)
        }
    }
}