package com.the.playting.policy.infrastructure.repository

import com.the.playting.policy.model.entities.Preference
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PreferenceRepository : JpaRepository<Preference, Long> {
}