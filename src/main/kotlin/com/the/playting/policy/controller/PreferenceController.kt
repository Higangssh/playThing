package com.the.playting.policy.controller

import com.the.playting.policy.model.dto.PreferenceRequestDto
import com.the.playting.policy.model.dto.PreferenceResponseDto
import com.the.playting.policy.service.PreferenceService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("preferences")
@Tag(name = "Preferences", description = "ex) description : 조용한 , 적극적인")
class PreferenceController(private val preferenceService: PreferenceService) {

    @GetMapping
    fun getAllPreferences(): ResponseEntity<List<PreferenceResponseDto>> {
        val preferences = preferenceService.getAllPreferences()
        return ResponseEntity(preferences, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getPreferenceById(@PathVariable id: Long): ResponseEntity<PreferenceResponseDto> {
        val preference = preferenceService.getPreferenceById(id) ?: return ResponseEntity(HttpStatus.NOT_FOUND)
        return ResponseEntity(preference, HttpStatus.OK)
    }

    @PostMapping
    fun createPreference(@RequestBody preferenceRequestDto: PreferenceRequestDto): ResponseEntity<PreferenceResponseDto> {
        val createdPreference = preferenceService.createPreference(preferenceRequestDto)
        return ResponseEntity(createdPreference, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updatePreference(
        @PathVariable id: Long,
        @RequestBody preferenceRequestDto: PreferenceRequestDto
    ): ResponseEntity<PreferenceResponseDto> {
        val updatedPreference = preferenceService.updatePreference(id, preferenceRequestDto) ?: return ResponseEntity(
            HttpStatus.NOT_FOUND
        )
        return ResponseEntity(updatedPreference, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deletePreference(@PathVariable id: Long): ResponseEntity<Void> {
        preferenceService.deletePreference(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

}