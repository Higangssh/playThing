package com.the.playting.policy.infrastructure.repository


import com.the.playting.policy.model.entities.Rule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RuleRepository : JpaRepository<Rule, Long> {
}