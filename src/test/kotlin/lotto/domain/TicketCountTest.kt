package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TicketCountTest : StringSpec({
    "should create TicketCount with valid count" {
        val ticketCount = TicketCount(3)
        ticketCount.getValue() shouldBe 3
    }

    "should create TicketCount with zero count" {
        val ticketCount = TicketCount(0)
        ticketCount.getValue() shouldBe 0
    }

    "should throw exception if count is negative" {
        val exception =
            shouldThrow<IllegalArgumentException> {
                TicketCount(-1)
            }
        exception.message shouldBe "티켓 수는 0 이상이어야 합니다."
    }
})
