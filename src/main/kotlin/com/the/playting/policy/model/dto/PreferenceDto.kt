package com.the.playting.policy.model.dto

import com.the.playting.policy.model.entities.Preference

data class PreferenceRequestDto(
    val description: String
){
    fun toEntity(): Preference = Preference(
        description = description,
    )
}

data class PreferenceResponseDto(
    val id: Long,
    val description: String
)