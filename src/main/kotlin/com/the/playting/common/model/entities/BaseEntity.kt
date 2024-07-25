package com.the.playting.common.model.entities

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdAt: LocalDateTime =  LocalDateTime.MIN

    @LastModifiedDate
    @Column(nullable = false)
    var updatedAt: LocalDateTime =  LocalDateTime.MIN

    @PrePersist
    fun formattingBeforeCreateDate() {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val customLocalDateTime = LocalDateTime.now().format(formatter)
        createdAt = LocalDateTime.parse(customLocalDateTime, formatter)
        updatedAt = LocalDateTime.parse(customLocalDateTime, formatter)
    }

    @PreUpdate
    fun formattingBeforeModifiedDate() {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val customLocalDateTime = LocalDateTime.now().format(formatter)
        updatedAt = LocalDateTime.parse(customLocalDateTime, formatter)
    }
}
