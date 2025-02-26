package com.example.models.navigation

import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.tonavigationHistory() = navigation_history(
    NavID = this[Navigation_history.NavID],
    UsersID = this[Navigation_history.UsersID],
    start_location = this[Navigation_history.start_location],
    end_location = this[Navigation_history.end_location],
    travel_mode = this[Navigation_history.travel_mode],
    created_at = this[Navigation_history.created_at],
)