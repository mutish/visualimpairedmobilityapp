package com.example.repository

import com.example.models.alerts.Alerts
import com.example.models.alerts.alert
import com.example.models.alerts.toAlert
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class AlertRepository {
    fun getAllAlerts(): List<alert> = transaction {
        Alerts.selectAll().map {it.toAlert()}
    }
     //new alert
    fun newAlert(alertstype: String, alertsDescription: String, lat: Double, long:Double): Int?{
        return transaction{
            Alerts.insert{
                it[alertType]=alertstype
                it[alertDescription]=alertsDescription
                it[latitude]=lat.toBigDecimal()
                it[longitude]=long.toBigDecimal()
            } get Alerts.alertID
        }
    }
    // get alerts near user's location (within 100 m)
    fun getNearbyAlerts(lat: Double, long: Double, radius:Double= 100.0): List<alert> = transaction{
        Alerts.selectAll()
            .map{it.toAlert()}
            .filter{isWithinRadius(it.latitude.toDouble(), it.longitude.toDouble(),lat, long, radius)}
    }
    // Check if coordinates are within a given radius (Haversine formula can be used)
    fun isWithinRadius(lat1:Double, long1:Double, lat2:Double, long2:Double,radius:Double):Boolean{
        val earthRadius = 6371000.0
        val dLat = Math.toRadians(lat2 - lat1)
        val dLon = Math.toRadians(long2 - long1)
        val a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                Math.sin(dLon / 2) * Math.sin(dLon / 2)
        val c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
        val distance = earthRadius * c

        return distance <= radius
    }
}