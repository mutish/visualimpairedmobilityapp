package com.example.models.sosrequest

import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toSOS() = sos_request(
    SOS_ID =  this[sos_requests.SOS_ID],
    UsersID = this[sos_requests.UsersID],
    SOS_Status = this[sos_requests.SOS_Status],
    latitude =  this[sos_requests.latitude].toDouble(),
    longitude = this[sos_requests.longitude].toDouble(),
    ntime = this[sos_requests.ntime],
    recipient = this[sos_requests.recipient],
)