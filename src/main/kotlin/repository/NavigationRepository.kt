package com.example.repository

import com.example.models.navigation.navigationHistory
import com.example.models.navigation.navigation_history
import com.example.models.navigation.tonavigationHistory
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

//CRUD Operations
class NavigationRepository {
    // add a location
   fun addNavigationHistory(startPoint: String, endPoint: String, travelMode: String) {
       return transaction{
           navigationHistory.insert{
               it[start_location] = startPoint
               it[end_location] = endPoint
               it[travel_mode] = travelMode

           }get navigationHistory.NavID // retrieve inserted Nav ID
       }
   }
    //fetch by ID
    fun getNavigationHistotybyID(NavID: Int): navigation_history? = transaction {
        navigationHistory.selectAll().where { navigationHistory.NavID eq NavID}
            .map{it.tonavigationHistory()}
            .singleOrNull()
    }
    //fetch all travel history
    fun getAllNavigationHistory(): List<navigation_history> = transaction {
        navigationHistory.selectAll().map{it.tonavigationHistory()}
    }
    //delete log
    fun deleteNavigationHistory(navID: Int): Boolean = transaction{
        navigationHistory.deleteWhere { NavID eq navID }>0
    }


}