package com.example.routes

import com.example.models.navigation.navigation_history
import com.example.repository.NavigationRepository
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

//endpoints
fun Application.navigationRoutes(){
    val navRepository = NavigationRepository()
    routing {
        //all travel logs
        get("/navigation"){
          call.respond(navRepository.getAllNavigationHistory())
        }
        //byID
        get("/navigation/{NavID}"){
            val navID = call.parameters["NavID"]?.toIntOrNull()
            if(navID == null){
                call.respond("Invalid Navigation ID")
                return@get
            }
            val navhistory = navRepository.getNavigationHistotybyID(navID)
            if(navhistory != null) call.respond(navhistory) else call.respond("Navigation history not found")

        }
        //new navigation route
        post("/navigation"){
            val navHistory = call.receive<navigation_history>()
            val newNavID = navRepository.addNavigationHistory(
                startPoint = navHistory.start_location,
                endPoint = navHistory.end_location,
                travelMode = navHistory.travel_mode
            )
            if(newNavID != null){
                call.respond("New navigation route added successfully with ID: $newNavID")
            }else {
                call.respond("Failed to add navigation route. Try again")
            }
        }
        // delete route
        delete("/navigation/{NavID}"){
            val navID = call.parameters["NavID"]?.toIntOrNull()
            if(navID == null){
                call.respond("Invalid Navigation ID")
                return@delete
            }
            val deleted = navRepository.deleteNavigationHistory(navID)
            call.respond(if(deleted) "Navigation route deleted successfully" else "Failed to remove navigation route. Try again")
        }
    }

}