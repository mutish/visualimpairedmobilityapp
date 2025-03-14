package com.example

import com.example.database.DatabaseFactory
import com.example.routes.*
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import java.io.FileInputStream

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
//    configureSerialization()
//    configureRouting()
    configureFirebase()
    //initialise database
    DatabaseFactory.init()
    install(ContentNegotiation) {
        json()
    }

    //Define routes
    routing {
        userRoutes()
        sosRoutes()
        alertRoutes()
        eRoutes()
        navigationRoutes()
        settingRoutes()
    }

}
fun Application.configureFirebase(){
    val serviceAccount = FileInputStream("src/main/resources/serviceAccountkey.json") // Path to Firebase credentials

    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build()

    if (FirebaseApp.getApps().isEmpty()) {
        FirebaseApp.initializeApp(options)
    }
}
