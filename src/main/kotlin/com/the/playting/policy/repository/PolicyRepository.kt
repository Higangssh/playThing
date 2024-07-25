package com.the.playting.policy.repository

import com.the.playting.policy.model.entities.Policy
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PolicyRepository : JpaRepository<Policy ,Int> {

}