package com.the.playting.policy.service

import com.the.playting.policy.infrastructure.repository.PolicyRepository
import com.the.playting.policy.model.entities.Policy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional


@SpringBootTest
@DisplayName("정책 관련 테스트")
@ActiveProfiles(value = ["test"])
@Transactional
class PolicyServiceTest{

    @Autowired
    private lateinit var policyRepository: PolicyRepository


    @Test
    fun `여러_정책_엔티티를_저장후_모든_정책이_반환된다`() {
        // given
        val policy1 = Policy(
            title = "테스트 정책 1",
            content = "이것은 테스트 정책 내용 1입니다"
        )
        val policy2 = Policy(
            title = "테스트 정책 2",
            content = "이것은 테스트 정책 내용 2입니다"
        )

        policyRepository.save(policy1)
        policyRepository.save(policy2)

        // when
        val allPolicies = policyRepository.findAll()

        // then
        assertThat(allPolicies).isNotNull
        assertThat(allPolicies).hasSize(2)
        assertThat(allPolicies).extracting("title").containsExactly("테스트 정책 1", "테스트 정책 2")
        assertThat(allPolicies).extracting("content").containsExactly("이것은 테스트 정책 내용 1입니다", "이것은 테스트 정책 내용 2입니다")
    }

    @Test
    fun `정책_엔티티를_저장한_후_아이디로_조회하면_저장된_정책이_반환된다`() {
        // given
        val policy = Policy(
            title = "테스트 정책",
            content = "이것은 테스트 정책 내용입니다"
        )

        // when
        val savedPolicy = policyRepository.save(policy)
        // then
        assertThat(savedPolicy).isNotNull
        assertThat(savedPolicy.id).isNotNull
        assertThat(savedPolicy.title).isEqualTo(policy.title)
        assertThat(savedPolicy.content).isEqualTo(policy.content)

        val foundPolicy = policyRepository.findById(savedPolicy.id).orElse(null)
        assertThat(foundPolicy).isNotNull
        assertThat(foundPolicy?.title).isEqualTo(policy.title)
        assertThat(foundPolicy?.content).isEqualTo(policy.content)

    }
}