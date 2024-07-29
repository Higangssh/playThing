package com.the.playting.policy.service

import com.the.playting.policy.infrastructure.repository.RuleRepository
import com.the.playting.policy.model.dto.RuleRequestDto
import com.the.playting.policy.model.dto.RuleResponseDto
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class RuleService(private val ruleRepository: RuleRepository) {

    fun getAllRoles(): List<RuleResponseDto> {
        return ruleRepository.findAll(Sort.by(Sort.Order.asc("createdAt"))).map { it.toDto() }
    }

    fun getRoleById(id: Long): RuleResponseDto? {
        return ruleRepository.findByIdOrNull(id)?.toDto()
    }

    fun createRole(ruleRequestDto: RuleRequestDto): RuleResponseDto {
        val role = ruleRequestDto.toEntity()
        return ruleRepository.save(role).toDto()
    }

    fun updateRole(id: Long, roleDto: RuleRequestDto): RuleResponseDto? {
        val existingRole = ruleRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("Role not found")
        existingRole.title = roleDto.title
        existingRole.content = roleDto.content
        return ruleRepository.save(existingRole).toDto()
    }

    fun deleteRole(id: Long) {
        ruleRepository.deleteById(id)
    }
}
