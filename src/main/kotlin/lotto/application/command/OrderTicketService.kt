package lotto.application.command

import lotto.application.RateOfReturnCalculator
import lotto.common.value.Money
import lotto.common.value.Money.Companion.toMoney
import lotto.common.value.Quantity
import lotto.domain.Order
import lotto.domain.Tickets
import lotto.domain.enums.Prize
import lotto.domain.enums.TicketType
import lotto.domain.policy.PricePolicy
import lotto.domain.vo.LotteryNumber
import lotto.domain.vo.LotteryNumbers
import java.math.RoundingMode

class OrderTicketService(
    private val pricePolicy: PricePolicy
) {
    fun orderTickets(orderInfo: List<OrderInfo>): Order {
        val ticketsList = orderInfo.map { orderTickets(it.paymentPrice, it.ticketType, it.lotteryNumbers) }
        val paymentPrice = orderInfo.sumOf { it.paymentPrice.value }.toMoney()
        val mergedTickets = Tickets.merge(ticketsList)
        val order = Order(paymentPrice = paymentPrice, tickets = mergedTickets)
        order.complete()
        return order
    }

    private fun orderTickets(paymentPrice: Money, ticketType: TicketType, lotteryNumbers: List<LotteryNumbers>): Tickets {
        val unitPrice = pricePolicy.apply()
        val quantity = Quantity((paymentPrice / unitPrice).value.setScale(0, RoundingMode.DOWN).toInt())
        return Tickets.of(quantity = quantity, pricePolicy = pricePolicy, ticketType = ticketType, lotteryNumbers = lotteryNumbers)
    }

    fun getLotteryNumbers(order: Order): List<LotteryNumbers> = order.toLotteryNumbers()

    fun confirmPrizeByOrder(winLotteryNumbers: LotteryNumbers, order: Order, bonusNumber: LotteryNumber): List<Prize> {
        return order.toLotteryNumbers().map {
            winLotteryNumbers.findPrize(it, bonusNumber)
        }
    }

    fun calculateRateOfReturn(order: Order, prizeList: List<Prize>): Double {
        val paymentPrice = order.paymentPrice
        val prizeAmount = prizeList.sumOf { it.amount.value }.toMoney()
        val rateOfReturn = RateOfReturnCalculator.calculate(paymentPrice = paymentPrice, prizeAmount = prizeAmount)
        return rateOfReturn.toDouble()
    }

    fun availableTicketPrice(manualTicketCount: Quantity): Money {
        val unitPrice = pricePolicy.apply()
        return unitPrice * manualTicketCount
    }

    data class OrderInfo(
        val paymentPrice: Money,
        val ticketType: TicketType,
        val lotteryNumbers: List<LotteryNumbers> = listOf()
    )
}
