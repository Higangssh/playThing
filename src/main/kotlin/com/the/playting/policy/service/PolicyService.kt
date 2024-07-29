package com.the.playting.policy.service
import com.the.playting.policy.model.dto.PolicyRequestDto
import com.the.playting.policy.model.dto.PolicyResponseDto
import com.the.playting.policy.infrastructure.repository.PolicyRepository
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PolicyService(private val policyRepository: PolicyRepository) {

    fun getAllPolicies(): List<PolicyResponseDto> {
        return policyRepository.findAll(Sort.by(Sort.Order.asc("createdAt"))).map { it.toDto() }
    }

    fun getPolicyById(id: Long): PolicyResponseDto? {
        return policyRepository.findByIdOrNull(id)?.toDto();
    }

    fun createPolicy(policyDto: PolicyRequestDto): PolicyResponseDto {
        val policy = policyDto.toEntity()
        return policyRepository.save(policy).toDto()
    }

    fun updatePolicy(id: Long, policyDto: PolicyRequestDto): PolicyResponseDto? {
        val existingPolicy = policyRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("Policy not found")

        return policyRepository.save(existingPolicy).toDto()
    }

    fun deletePolicy(id: Long) {
        policyRepository.deleteById(id)
    }


}