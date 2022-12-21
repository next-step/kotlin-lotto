package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class WinnerTest : StringSpec({

    "입력 값을 기반으로 반환 된 Winner에 대해 매칭 값을 반환한다" {
        val winner = Winner("1,2,3,4,5,6", "7")
        val issueTickets = IssuanceTickets(listOf(Ticket(Numbers(issueNumbers = listOf(1, 2, 3, 4, 5, 6)))))
        winner.checkNumberMatch(issueTickets).matchInfo[Reward.FIRST] shouldBe 1
    }
})
