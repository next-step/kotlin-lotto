package lotto.application

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import lotto.application.command.OrderTicketService
import lotto.common.value.Money.Companion.toMoney
import lotto.common.value.Quantity
import lotto.domain.enums.Prize
import lotto.domain.enums.TicketType
import lotto.domain.policy.DefaultPricePolicy
import lotto.domain.vo.LotteryNumber
import lotto.domain.vo.LotteryNumbers
import lotto.domain.vo.generateList

class OrderTicketServiceTest : BehaviorSpec({

    given("가격 정책이 1000원 티켓을 살 수 있을 때") {

        val pricePolicy = DefaultPricePolicy
        val orderTicketService = OrderTicketService(pricePolicy = pricePolicy)

        `when`("14000원으로 자동 티켓을 주문 하면") {
            val paymentPrice = 14_000L.toMoney()
            val ticketType = TicketType.AUTO
            val autoOrderInfo = OrderTicketService.OrderInfo(paymentPrice, ticketType)
            val order = orderTicketService.orderTickets(listOf(autoOrderInfo))

            then("14장의 티켓을 살 수 있다") {
                order.tickets.size() shouldBe 14
            }

            then("로또의 당첨여부를 확인할 수 있다") {
                val lotteryNumbers = orderTicketService.getLotteryNumbers(order)
                val winLotteryNumbers = lotteryNumbers[0]
                val bonusNumber = LotteryNumber(value = 7)
                val prizeList = orderTicketService.confirmPrizeByOrder(winLotteryNumbers, order, bonusNumber)
                prizeList.contains(Prize.FIRST).shouldBeTrue()
            }

            then("로또의 수익률을 계산할 수 있다") {
                val lotteryNumbers = orderTicketService.getLotteryNumbers(order)
                val winLotteryNumbers = lotteryNumbers[0]
                val bonusNumber = LotteryNumber(value = 7)
                val prizeList = orderTicketService.confirmPrizeByOrder(winLotteryNumbers, order, bonusNumber)
                val rateOfReturn = orderTicketService.calculateRateOfReturn(order, prizeList)
                (rateOfReturn >= 1).shouldBeTrue()
            }
        }

        `when`("14000원으로 3장의 수동 티켓과 나머지 자동 티켓 주문을 하면") {
            val paymentPrice = 14_000L.toMoney()

            val manualQuantity = Quantity(3)

            then("수량에 따른 가격을 확인할 수 있다") {
                val quantity = Quantity(3)
                val manualTicketPrice = orderTicketService.availableTicketPrice(quantity)
                manualTicketPrice shouldBe 3_000L.toMoney()
            }

            val manualTicketPrice = orderTicketService.availableTicketPrice(manualQuantity)
            val lotteryNumbers = listOf(
                LotteryNumbers(generateList(1, 6)),
                LotteryNumbers(generateList(2, 7)),
                LotteryNumbers(generateList(3, 8))
            )
            val manualOrderInfo = OrderTicketService.OrderInfo(manualTicketPrice, TicketType.MANUAL, lotteryNumbers)

            val autoTicketPrice = paymentPrice - manualTicketPrice
            val autoOrderInfo = OrderTicketService.OrderInfo(autoTicketPrice, TicketType.AUTO)

            val orderInfo = listOf(manualOrderInfo, autoOrderInfo)

            val order = orderTicketService.orderTickets(orderInfo)

            then("3장의 수동 티켓과 11장의 자동 티켓을 살 수 있다") {
                val manualTicketCount = order.countTicket(TicketType.MANUAL)
                val autoTicketCount = order.countTicket(TicketType.AUTO)
                val totalTicketCount = order.countTotalTicket()

                manualTicketCount shouldBe 3
                autoTicketCount shouldBe 11
                totalTicketCount shouldBe 14
            }

            then("로또의 당첨여부를 확인할 수 있다") {
                val winLotteryNumbers = LotteryNumbers(generateList(1, 6))
                val bonusNumber = LotteryNumber(value = 7)
                val prizeList = orderTicketService.confirmPrizeByOrder(winLotteryNumbers, order, bonusNumber)
                prizeList.contains(Prize.FIRST).shouldBeTrue()
            }
        }
    }
})
