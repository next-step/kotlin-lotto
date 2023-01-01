package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import lotto.domain.enums.TicketStatus
import lotto.domain.enums.TicketType
import lotto.domain.policy.DefaultPricePolicy
import lotto.domain.policy.LotteryNumberAutoGenerateStrategy

class TicketTest : FreeSpec({

    val pricePolicy = DefaultPricePolicy
    val lotteryNumbersPolicy = LotteryNumberAutoGenerateStrategy

    "로또 티켓은 필수 필드로" - {
        "가격 정보를 가지고 있다" {
            val ticket = Ticket(pricePolicy = pricePolicy, lotteryNumbersGenerateStrategy = lotteryNumbersPolicy, TicketType.AUTO)
            ticket.price.shouldNotBeNull()
        }

        "발급 상태를 가지고 있다" {
            val ticket = Ticket(pricePolicy = pricePolicy, lotteryNumbersGenerateStrategy = lotteryNumbersPolicy, TicketType.AUTO)
            ticket.status shouldBe TicketStatus.INIT
        }

        "추첨 번호를 가지고 있다" {
            val ticket = Ticket(pricePolicy = pricePolicy, lotteryNumbersGenerateStrategy = lotteryNumbersPolicy, TicketType.AUTO)
            ticket.lotteryNumbers.shouldNotBeNull()
        }
    }

    "티켓은 발급을 할 수 있다" {
        val ticket = Ticket(pricePolicy = pricePolicy, lotteryNumbersGenerateStrategy = lotteryNumbersPolicy, TicketType.AUTO)
        ticket.issue()
        ticket.status shouldBe TicketStatus.ISSUE
    }

    "티켓은 INIT 상태에만 발급을 할 수 있다." {
        val ticket = Ticket(pricePolicy = pricePolicy, lotteryNumbersGenerateStrategy = lotteryNumbersPolicy, TicketType.AUTO)
        ticket.issue()
        shouldThrow<IllegalStateException> { ticket.issue() }
    }
})
