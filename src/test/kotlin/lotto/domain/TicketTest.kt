package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeSorted
import io.kotest.matchers.shouldBe
import lotto.domain.Ticket.Companion.LOTTO_RANGE

class TicketTest : StringSpec({

    val ticket = Ticket()

    "티켓의 번호는 총 6개여야 한다" {
        ticket.getIssueNumbers().size shouldBe 6
    }

    "티켓의 번호는 1부터 45 사이의 숫자여야 한다" {
        ticket.getIssueNumbers().filter { it in LOTTO_RANGE }.size shouldBe 6
    }

    "티켓은 정렬되어 있어야 한다" {
        ticket.getIssueNumbers().shouldBeSorted()
    }

    "티켓의 유효성을 검사한다" {
        shouldThrow<IllegalArgumentException> { Ticket(Numbers(listOf(1, 2, 3, 4, 5))) }
        shouldThrow<IllegalArgumentException> { Ticket(Numbers(listOf(1, 2, 3, 4, 4))) }
    }

    "티켓의 숫자를 검사한다" {
        val drawNumbers = Numbers(listOf(1, 2, 3, 4, 5, 7))
        val ticketForCheck = Ticket(Numbers(listOf(1, 2, 3, 4, 5, 6)))
        ticketForCheck.getMatchingNumbersCount(drawNumbers) shouldBe 5
    }
})
