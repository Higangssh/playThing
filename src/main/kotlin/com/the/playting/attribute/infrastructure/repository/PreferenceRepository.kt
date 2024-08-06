package com.the.playting.attribute.infrastructure.repository

import com.the.playting.attribute.model.entities.Preference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PreferenceRepository : JpaRepository<Preference, Long> {
}