package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import lotto.domain.DefaultPricePolicy
import lotto.domain.Ticket
import lotto.domain.TicketStatus

class TicketTest : FreeSpec({

    val pricePolicy = DefaultPricePolicy()

    "로또 티켓은 가격 정보를 가지고 있다" {
        val ticket = Ticket(pricePolicy = pricePolicy)
        ticket.price.shouldNotBeNull()
    }

    "로또 티켓은 발급 상태를 가지고 있다" {
        val ticket = Ticket(pricePolicy = pricePolicy)
        ticket.status shouldBe TicketStatus.INIT
    }

    "로또 티켓은 발급을 할 수 있다" {
        val ticket = Ticket(pricePolicy = pricePolicy)
        ticket.issue()
        ticket.status shouldBe TicketStatus.ISSUE
    }
})