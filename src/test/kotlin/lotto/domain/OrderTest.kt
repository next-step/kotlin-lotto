package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import lotto.common.value.Money.Companion.toMoney
import lotto.common.value.Quantity
import lotto.domain.enums.TicketType
import lotto.domain.policy.DefaultPricePolicy

class OrderTest : FreeSpec({

    val paymentPrice = 14000L.toMoney()
    val quantity = Quantity(14)
    val ticketType = TicketType.AUTO
    val pricePolicy = DefaultPricePolicy

    "가격정책과 티켓타입과 수량으로 주문을 생성할 수 있다" - {
        val tickets = Tickets.of(quantity = quantity, pricePolicy = pricePolicy, ticketType = ticketType)

        val order = Order(paymentPrice = paymentPrice, tickets = tickets)
        order.shouldNotBeNull()

        "주문이 완료되면 티켓의 상태가 발급으로 변경된다" {
            order.complete()
            shouldThrow<IllegalStateException> { tickets.issue() }
        }

        "티켓의 전체 수량을 확인할 수 있다" {
            val ticketCount = order.countTotalTicket()
            ticketCount shouldBe quantity.value
        }

        "티켓의 타입별 수량을 확인할 수 있다" {
            val autoTicketCount = order.countTicket(TicketType.AUTO)
            val manualTicketCount = order.countTicket(TicketType.MANUAL)
            autoTicketCount shouldBe quantity.value
            manualTicketCount shouldBe 0
        }

        "티켓의 추첨번호 리스트를 확인할 수 있다" {
            val lotteryNumbersList = order.toLotteryNumbers()
            lotteryNumbersList.shouldNotBeNull()
            lotteryNumbersList.size shouldBe quantity.value
        }
    }

    "총 가격이랑 지불금액이 맞지 않으면 에러가 발생한다" {
        val tickets = Tickets.of(quantity = quantity, pricePolicy = pricePolicy, ticketType = ticketType)
        val notMatchedPaymentPrice = 1_000L.toMoney()

        shouldThrow<IllegalArgumentException> { Order(paymentPrice = notMatchedPaymentPrice, tickets = tickets) }
    }
})
