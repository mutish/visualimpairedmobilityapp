package com.example.models.econtacts

import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toEcontact() = emergency_contact(
    ECID = this[emergency_contacts.EC_ID],
    UsersID = this[emergency_contacts.UsersID],
    contact_name = this[emergency_contacts.Contact_name],
    contact_phone = this[emergency_contacts.Contact_phone],
    relationship = this[emergency_contacts.relationship],
    createdat = this[emergency_contacts.createdat],


)