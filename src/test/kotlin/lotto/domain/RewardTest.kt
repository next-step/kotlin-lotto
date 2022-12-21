package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RewardTest : StringSpec({

    "매칭되는 숫자에 따른 등수 반환" {
        val ticket = Ticket(Numbers(issueNumbers = listOf(1, 2, 3, 4, 5, 6)))
        val numbers = Numbers(issueNumbers = listOf(1, 2, 3, 4, 5, 7), 6)
        Reward.find(ticket, numbers) shouldBe Reward.SECOND
    }
})
