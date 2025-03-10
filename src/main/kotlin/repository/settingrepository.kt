package com.example.repository

import com.example.models.settings.setting
import com.example.models.settings.settingsTable
import com.example.models.settings.toSetting
import org.jetbrains.exposed.sql.javatime.CurrentTimestamp
import org.jetbrains.exposed.sql.javatime.datetime
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class settingrepository {
    //get User settingsTable
    fun getUserSettings(UsersID: Int): setting? = transaction {
        settingsTable.selectAll().where{settingsTable.UsersID eq UsersID}
            .map{it.toSetting()}
            .singleOrNull()
    }
    //update
    fun updateUserSetting(userID: Int, newSetting: setting): Boolean = transaction {
        settingsTable.update({settingsTable.UsersID eq userID}){
            it[Audio_guidance]= newSetting.audioGuidance
            it[Haptic_feedback]= newSetting.hapticFeedback
            it[Alert_notification]=newSetting.alertNotification
            it[updated_at]=newSetting.updated_at
        } >0
    }
    // RESET
    fun resetUserSetting(usersID: Int): Boolean = transaction {
        settingsTable.update({settingsTable.UsersID eq usersID}){
            it[Audio_guidance] = true
            it[Haptic_feedback] = true
            it[Alert_notification] = true
            it[updated_at] = CurrentTimestamp()
        } > 0

    }
}