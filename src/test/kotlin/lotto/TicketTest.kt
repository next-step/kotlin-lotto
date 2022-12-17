package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import lotto.domain.Ticket
import lotto.domain.enums.TicketStatus
import lotto.domain.policy.LotteryNumberAutoGenerateStrategy
import lotto.domain.policy.DefaultPricePolicy

class TicketTest : FreeSpec({

    val pricePolicy = DefaultPricePolicy
    val lotteryNumbersPolicy = LotteryNumberAutoGenerateStrategy

    "로또 티켓은 필수 필드로" - {
        "가격 정보를 가지고 있다" {
            val ticket = Ticket(pricePolicy = pricePolicy, lotteryNumbersGenerateStrategy = lotteryNumbersPolicy)
            ticket.price.shouldNotBeNull()
        }

        "발급 상태를 가지고 있다" {
            val ticket = Ticket(pricePolicy = pricePolicy, lotteryNumbersGenerateStrategy = lotteryNumbersPolicy)
            ticket.status shouldBe TicketStatus.INIT
        }

        "추첨 번호를 가지고 있다" {
            val ticket = Ticket(pricePolicy = pricePolicy, lotteryNumbersGenerateStrategy = lotteryNumbersPolicy)
            ticket.lotteryNumbers.shouldNotBeNull()
        }
    }

    "티켓은 발급을 할 수 있다" {
        val ticket = Ticket(pricePolicy = pricePolicy, lotteryNumbersGenerateStrategy = lotteryNumbersPolicy)
        ticket.issue()
        ticket.status shouldBe TicketStatus.ISSUE
    }

    "티켓은 INIT 상태에만 발급을 할 수 있다." {
        val ticket = Ticket(pricePolicy = pricePolicy, lotteryNumbersGenerateStrategy = lotteryNumbersPolicy)
        ticket.issue()
        shouldThrow<IllegalStateException> { ticket.issue() }
    }
})