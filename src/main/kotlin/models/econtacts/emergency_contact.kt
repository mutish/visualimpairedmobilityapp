package com.example.models.econtacts

import kotlinx.serialization.Contextual
import java.time.LocalDateTime

data class emergency_contact (
    val ECID: Int,
    val UsersID: Int,
    val contact_name: String,
    val contact_phone: String,
    val relationship: String,
    @Contextual val createdat: LocalDateTime = LocalDateTime.now(),
    )
