package com.the.playting.policy.controller

import com.the.playting.policy.model.dto.PolicyRequestDto
import com.the.playting.policy.model.dto.PolicyResponseDto
import com.the.playting.policy.service.PolicyService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("policies")
class PolicyController(private val policyService: PolicyService) {


    @GetMapping
    fun getAllPolicies(): ResponseEntity<List<PolicyResponseDto>> {
        val policies = policyService.getAllPolicies()
        return ResponseEntity(policies, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getPolicyById(@PathVariable id: Int): ResponseEntity<PolicyResponseDto> {
        val policy = policyService.getPolicyById(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(policy, HttpStatus.OK)
    }

    @PostMapping
    fun createPolicy(@RequestBody policyRequestDto: PolicyRequestDto): ResponseEntity<PolicyResponseDto> {
        val createdPolicy = policyService.createPolicy(policyRequestDto)
        return ResponseEntity(createdPolicy, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updatePolicy(@PathVariable id: Int, @RequestBody policyRequestDto: PolicyRequestDto): ResponseEntity<PolicyResponseDto> {
        val updatedPolicy = policyService.updatePolicy(id, policyRequestDto) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(updatedPolicy, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deletePolicy(@PathVariable id: Int): ResponseEntity<Void> {
        policyService.deletePolicy(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}