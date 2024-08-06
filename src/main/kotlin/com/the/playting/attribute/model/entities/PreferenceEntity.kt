package com.the.playting.attribute.model.entities

import com.the.playting.attribute.model.dto.PreferenceResponseDto
import jakarta.persistence.*

@Entity
@Table(name = "preference_tbl")
class Preference (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = 0,

    @Column(nullable = false)
    var description: String
){
    fun toDto() = PreferenceResponseDto(
        id = this.id,
        description = this.description
    )
}