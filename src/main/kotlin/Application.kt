package com.example

import com.example.database.DatabaseFactory
import com.example.repository.UserRepository
import com.example.routes.userRoutes
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
//    configureSerialization()
//    configureRouting()
    //initialise database
    DatabaseFactory.init()
    install(ContentNegotiation) {
        json()
    }
    //Define routes
    routing {
        userRoutes()
    }

}
