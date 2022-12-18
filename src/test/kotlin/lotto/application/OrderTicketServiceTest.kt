package lotto.application

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import lotto.application.command.OrderTicketService
import lotto.common.value.Money.Companion.toMoney
import lotto.domain.enums.Prize
import lotto.domain.enums.TicketType
import lotto.domain.policy.DefaultPricePolicy

class OrderTicketServiceTest : BehaviorSpec({

    given("가격 정책이 1000원 티켓을 살 수 있을 때") {

        val pricePolicy = DefaultPricePolicy
        val orderTicketService = OrderTicketService(pricePolicy = pricePolicy)

        `when`("14000원으로 자동 티켓을 주문 하면") {
            val paymentPrice = 14_000L.toMoney()
            val ticketType = TicketType.AUTO
            val order = orderTicketService.orderTickets(paymentPrice, ticketType)

            then("14장의 티켓을 살 수 있다") {
                order.tickets.size() shouldBe 14
            }

            then("로또의 당첨여부를 확인할 수 있다") {
                val lotteryNumbers = orderTicketService.getLotteryNumbers(order)
                val winLotteryNumbers = lotteryNumbers[0]
                val prizeList = orderTicketService.checkLotteryNumbers(winLotteryNumbers, order)
                prizeList.contains(Prize.SIX).shouldBeTrue()
            }

            then("로또의 수익률을 계산할 수 있다") {
                val lotteryNumbers = orderTicketService.getLotteryNumbers(order)
                val winLotteryNumbers = lotteryNumbers[0]
                val prizeList = orderTicketService.checkLotteryNumbers(winLotteryNumbers, order)
                val rateOfReturn = orderTicketService.calculateRateOfReturn(order, prizeList)
                (rateOfReturn >= 1).shouldBeTrue()
            }
        }
    }
})
