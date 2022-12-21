package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MatchInfoTest : StringSpec({

    "당첨 금액 확인" {
        val matchInfo = MatchInfo(mutableMapOf(Reward.FIFTH to 1, Reward.FOURTH to 1))
        matchInfo.getRevenueFee() shouldBe 55000
    }

    "발급 된 번호와 당첨 번호를 비교" {
        val numbers  = Numbers(issueNumbers = listOf(1,2,3,4,5,6))
        val issueTicket = IssuanceTickets(listOf(Ticket(Numbers(issueNumbers = listOf(1,2,3,4,5,6)))))
        MatchInfo.checkWinner(issueTicket, numbers).matchInfo[Reward.FIRST] shouldBe 1
    }
})
