package com.example.models.navigation

import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.tonavigationHistory() = navigation_history(
    NavID = this[navigationHistory.NavID],
    UsersID = this[navigationHistory.UsersID],
    start_location = this[navigationHistory.start_location],
    end_location = this[navigationHistory.end_location],
    travel_mode = this[navigationHistory.travel_mode],
    created_at = this[navigationHistory.created_at],
)