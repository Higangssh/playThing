package com.the.playting.policy.model.entities

import com.the.playting.common.model.entities.BaseEntity
import com.the.playting.policy.model.dto.RuleResponseDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name= "rule_tbl")
class Rule(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long = 0,

    @Column(nullable = false, name = " rule_title")
    var title: String,

    @Column(nullable = false, name = " rule_content")
    var content: String

) : BaseEntity() {

    fun toDto() = RuleResponseDto(
        id = this.id,
        title = this.title,
        content = this.content,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )

}