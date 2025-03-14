package com.example.routes

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserRecord
import io.ktor.server.application.*

suspend fun ApplicationCall.verifyFirebaseToken(): String?{
    val authHeader = request.headers["Authorization"]?: return null
    if(!authHeader.startsWith("Bearer ")) return null

    val idToken = authHeader.removePrefix("Bearer ")
    return try{
        val decodeToken =FirebaseAuth.getInstance().verifyIdToken(idToken)
        val userRecord: UserRecord= FirebaseAuth.getInstance().getUser(decodeToken.uid)
        userRecord.displayName ?: "Unknown User"
    }catch (e:Exception){
        null
    }
}
