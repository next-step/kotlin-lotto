package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import lotto.common.value.Money
import lotto.common.value.Quantity
import lotto.domain.Order
import lotto.domain.Tickets
import lotto.domain.enums.TicketType
import lotto.domain.policy.DefaultPricePolicy

class OrderTest : FreeSpec({

    val paymentPrice = Money.from(14000)
    val quantity = Quantity(14)
    val ticketType = TicketType.AUTO
    val pricePolicy = DefaultPricePolicy

    "가격정책과 티켓타입과 수량으로 주문을 생성할 수 있다" - {
        val tickets = Tickets.from(quantity = quantity, pricePolicy = pricePolicy, ticketType = ticketType)

        val order = Order(paymentPrice = paymentPrice, tickets = tickets)
        order.shouldNotBeNull()

        "주문이 완료되면 티켓의 상태가 발급으로 변경된다" {
            order.complete()
            shouldThrow<IllegalStateException> { tickets.issue() }
        }
    }

    "총 가격이랑 지불금액이 맞지 않으면 에러가 발생한다" {
        val tickets = Tickets.from(quantity = quantity, pricePolicy = pricePolicy, ticketType = ticketType)
        val notMatchedPaymentPrice = Money.from(1000)

        shouldThrow<IllegalArgumentException> { Order(paymentPrice = notMatchedPaymentPrice, tickets = tickets) }
    }
})
