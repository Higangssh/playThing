package com.the.playting.attribute.service

import com.the.playting.attribute.infrastructure.repository.PreferenceRepository
import com.the.playting.attribute.model.dto.PreferenceRequestDto
import com.the.playting.attribute.model.dto.PreferenceResponseDto
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PreferenceService(private val preferenceRepository: PreferenceRepository) {

    fun getAllPreferences(): List<PreferenceResponseDto> {
        return preferenceRepository.findAll(Sort.by(Sort.Order.asc("id"))).map { it.toDto() }
    }

    fun getPreferenceById(id: Long): PreferenceResponseDto? {
        return preferenceRepository.findByIdOrNull(id)?.toDto()
    }

    fun createPreference(preferenceDto: PreferenceRequestDto): PreferenceResponseDto {
        val preference = preferenceDto.toEntity()
        return preferenceRepository.save(preference).toDto()
    }

    fun updatePreference(id: Long, preferenceDto: PreferenceRequestDto): PreferenceResponseDto? {
        val existingPreference = preferenceRepository.findByIdOrNull(id) ?: throw IllegalArgumentException("Preference not found")
        existingPreference.description = preferenceDto.description
        return preferenceRepository.save(existingPreference).toDto()
    }

    fun deletePreference(id: Long) {
        preferenceRepository.deleteById(id)
    }
}