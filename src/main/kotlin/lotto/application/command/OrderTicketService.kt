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
import lotto.domain.vo.LotteryNumbers
import java.math.RoundingMode

class OrderTicketService(
    private val pricePolicy: PricePolicy
) {
    fun orderTickets(paymentPrice: Money, ticketType: TicketType): Order {
        val unitPrice = pricePolicy.apply()
        val quantity = Quantity((paymentPrice / unitPrice).value.setScale(0, RoundingMode.DOWN).toLong())
        val tickets = Tickets.from(quantity = quantity, pricePolicy = pricePolicy, ticketType = ticketType)
        val order = Order(paymentPrice = paymentPrice, tickets = tickets)
        order.complete()
        return order
    }

    fun getLotteryNumbers(order: Order): List<LotteryNumbers> = order.toLotteryNumbers()

    fun confirmPrizeByOrder(winLotteryNumbers: LotteryNumbers, order: Order): List<Prize> {
        val prizeList = mutableListOf<Prize>()
        order.toLotteryNumbers().forEach {
            val prize = winLotteryNumbers.findPrize(it)
            prizeList.add(prize)
        }
        return prizeList.toList()
    }

    fun calculateRateOfReturn(order: Order, prizeList: List<Prize>): Double {
        val paymentPrice = order.paymentPrice
        val prizeAmount = prizeList.sumOf { it.amount.value }.toMoney()
        val rateOfReturn = RateOfReturnCalculator.calculate(paymentPrice = paymentPrice, prizeAmount = prizeAmount)
        return rateOfReturn.toDouble()
    }
}
