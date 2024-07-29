package com.the.playting.policy.controller

import com.the.playting.policy.model.dto.RuleRequestDto
import com.the.playting.policy.model.dto.RuleResponseDto
import com.the.playting.policy.service.RuleService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("rules")
@Tag(name = "Role", description = "ex) title: 제1규칙  content: 내용")
class RuleController(private val ruleService: RuleService) {

    @GetMapping
    fun getAllRoles(): ResponseEntity<List<RuleResponseDto>> {
        val roles = ruleService.getAllRoles()
        return ResponseEntity(roles, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getRoleById(@PathVariable id: Long): ResponseEntity<RuleResponseDto> {
        val role = ruleService.getRoleById(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(role, HttpStatus.OK)
    }

    @PostMapping
    fun createRole(@RequestBody ruleRequestDto: RuleRequestDto): ResponseEntity<RuleResponseDto> {
        val createdRole = ruleService.createRole(ruleRequestDto)
        return ResponseEntity(createdRole, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updateRole(@PathVariable id: Long, @RequestBody ruleRequestDto: RuleRequestDto): ResponseEntity<RuleResponseDto> {
        val updatedRole = ruleService.updateRole(id, ruleRequestDto) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(updatedRole, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteRole(@PathVariable id: Long): ResponseEntity<Void> {
        ruleService.deleteRole(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}
