package com.the.playting.policy.model.dto

import com.fasterxml.jackson.annotation.JsonGetter
import com.the.playting.policy.model.entities.Rule
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class RuleRequestDto (
    val id: Long?,
    val title: String,
    val content: String,
){
    fun toEntity() = Rule(
        id = this.id ?: 0,
        title = this.title,
        content = this.content,
    )
}


data class RuleResponseDto(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?
){
    @get:JsonGetter("createdAt")
    val formattedCreatedAt: String?
        get() = createdAt?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))

    @get:JsonGetter("updatedAt")
    val formattedUpdatedAt: String?
        get() = updatedAt?.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
}