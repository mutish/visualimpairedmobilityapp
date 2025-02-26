package com.example.routes

import com.example.models.econtacts.emergency_contact
import com.example.repository.eContactrepository
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.eRoutes(){
    val erepository = eContactrepository()
    routing {
        get("/emergency") {
            call.respond(erepository.getAllContacts())
        }

        //by ID
        get("/emergency/{ECID}") {
            val ECID = call.parameters["ECID"]?.toIntOrNull()
            if (ECID == null) {
                call.respond("Invalid contact ID.")
                return@get
            }
            val eContact = erepository.getUserbyId(ECID)
            if (eContact != null) call.respond(eContact) else call.respond("Contact not found.")
        }
        post("/emergency"){
            val eContact = call.receive<emergency_contact>()
            val newEcID = erepository.newEmergencyContact(
                contactname = eContact.contact_name,
                contactphone = eContact.contact_phone,
                relation = eContact.relationship
            )
            if(newEcID != null){
                call.respond("Successfully created new Emergency Contact.")
            }else{
                call.respond("Emergency contact creation failed.")
            }
        }
        put("/emergency/{ECID}") {
            val ECID = call.parameters["ECID"]?.toIntOrNull()
            if (ECID == null) {
                call.respond("Invalid contact ID.")
                return@put
            }
            val eContact = call.receive<emergency_contact>()
            val updatedEContact = erepository.updateEContact(ECID, eContact)
            call.respond(if (updatedEContact) "Successfully updated EContact." else "Emergency Contact failed. Try Again")
        }
        delete("/emergency/{ECID}") {
            val ECID = call.parameters["ECID"]?.toIntOrNull()
            if (ECID == null) {
                call.respond("Invalid contact ID.")
                return@delete
            }
            val deletedContact = erepository.deleteContact(ECID)
            call.respond(if (deletedContact) "Contact deleted successfully" else "Contact not found.")
        }
    }
}