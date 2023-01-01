package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import lotto.common.value.Money.Companion.toMoney
import lotto.domain.enums.TicketType
import lotto.domain.policy.DefaultPricePolicy
import lotto.domain.policy.LotteryNumberAutoGenerateStrategy

class TicketsTest : FreeSpec({

    val pricePolicy = DefaultPricePolicy
    val lotteryNumbersStrategy = LotteryNumberAutoGenerateStrategy
    val ticket = Ticket(pricePolicy = pricePolicy, lotteryNumbersGenerateStrategy = lotteryNumbersStrategy, TicketType.AUTO)

    "티켓 목록을 리스트로 만들 수 있다" - {
        val otherTicket = Ticket(pricePolicy = pricePolicy, lotteryNumbersGenerateStrategy = lotteryNumbersStrategy, TicketType.AUTO)
        val tickets = Tickets(tickets = listOf(ticket, otherTicket))

        "총 가격을 확인할 수 있다" {
            tickets.totalPrice() shouldBe 2000L.toMoney()
        }

        "발급되면 상태가 변경된다" {
            ticket.issue()
            shouldThrow<IllegalStateException> { tickets.issue() }
        }

        "수량을 확인할 수 있다" {
            val ticketCount = tickets.size()
            ticketCount shouldBe 2
        }

        "추첨번호 리스트를 확인할 수 있다" {
            val lotteryNumbersList = tickets.toLotteryNumbers()
            lotteryNumbersList.shouldNotBeNull()
            lotteryNumbersList.size shouldBe 2
        }
    }
})
