package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class IssuanceTicketsTest : StringSpec({

    "발급 된 번호와 당첨 번호를 비교"{
        val numbers  = Numbers(issueNumbers = listOf(1,2,3,4,5,6))
        val issueTicket = IssuanceTickets(listOf(Ticket(Numbers(issueNumbers = listOf(1,2,3,4,5,6)))))
        issueTicket.checkWinner(numbers).matchInfo[Reward.FIRST] shouldBe 1
    }
})
