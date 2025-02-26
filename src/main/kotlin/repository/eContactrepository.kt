package com.example.repository

import com.example.models.econtacts.emergency_contact
import com.example.models.econtacts.emergency_contacts
import com.example.models.econtacts.toEcontact
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class eContactrepository {
    //all contacts
    fun getAllContacts(): List<emergency_contact> = transaction{
        emergency_contacts.selectAll().map { it.toEcontact() }
    }
    //user by ID
    fun getUserbyId(ecID: Int): emergency_contact? = transaction {
        emergency_contacts.selectAll().where{emergency_contacts.EC_ID eq ecID}
            .map { it.toEcontact() }
            .singleOrNull()
    }

    // new contact
    fun newEmergencyContact(contactname:String, contactphone:String, relation:String): Int? {
        return transaction {
            emergency_contacts.insert{
                it[Contact_name] = contactname
                it[Contact_phone] = contactphone
                it[relationship] = relation

            }get emergency_contacts.EC_ID
        }
    }

    //update
    fun updateEContact(ecID: Int, emergencyContact: emergency_contact): Boolean = transaction{
        emergency_contacts.update({emergency_contacts.EC_ID eq ecID}){
            it[Contact_name] = emergencyContact.contact_name
            it[Contact_phone] = emergencyContact.contact_phone
            it[relationship]= emergencyContact.relationship
        }>0
    }
    fun deleteContact(ecID: Int): Boolean = transaction {
        emergency_contacts.deleteWhere { emergency_contacts.EC_ID eq ecID } > 0
    }
}