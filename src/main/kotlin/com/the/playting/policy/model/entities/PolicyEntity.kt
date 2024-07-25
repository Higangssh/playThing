package com.the.playting.policy.model.entities

import com.the.playting.common.model.entities.BaseEntity
import com.the.playting.policy.model.dto.PolicyResponseDto
import jakarta.persistence.*

@Entity
@Table(name = "policy_tbl")
class Policy(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int = 0,

    @Column(nullable = false , name = " policy_title")
    var title: String,

    @Column(nullable = false, name = " policy_content")
    var content: String

) : BaseEntity(){

    fun toDto() = PolicyResponseDto(
        id = this.id,
        title = this.title,
        content = this.content,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )
}

