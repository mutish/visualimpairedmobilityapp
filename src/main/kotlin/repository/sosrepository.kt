package com.example.repository

import com.example.models.sosrequest.sos_request
import com.example.models.sosrequest.sos_requests
import com.example.models.sosrequest.toSOS
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.time.LocalDateTime

class sosrepository {
    // fetch all requests
    fun getAllRequests(): List<sos_request> = transaction{
        sos_requests.selectAll().map { it.toSOS() }
    }

    //filter
    fun getSOSbyID(Sid: Int): sos_request? = transaction {
        sos_requests.selectAll().where{sos_requests.SOS_ID eq Sid}
            .map{it.toSOS()}
            .singleOrNull()
    }
    fun createSOS(usersID: Int, lat: Double, long:Double): Int? {
        return transaction {
            sos_requests.insert{
                it[UsersID]=usersID
                it[latitude] = lat.toBigDecimal()
                it[longitude] = long.toBigDecimal()
            } get sos_requests.SOS_ID
        }
    }
    fun updateSOS(sosID:Int, status:String): Boolean{
        return transaction {
            sos_requests.update({ sos_requests.SOS_ID.eq(sosID) }) {
                it[SOS_Status]=status
            }>0
        }

    }
//    fun deleteSOS(sosID:Int): Boolean{
//        return transaction {
//            sos_requests.deleteWhere { sos_requests.SOS_ID.eq(sosID) }>0
//        }

    }

