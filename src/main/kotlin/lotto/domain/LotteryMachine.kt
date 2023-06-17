package lotto.domain

import lotto.scaleDown

object LotteryMachine {
    private val LOTTERY_PRICE = Money(1_000)
    private const val QUANTITY_SCALE = 0

    fun issueLotteryTicket(money: Money): LotteryTicket {
        val lotteryQuantity = getQuantity(money)
        val lotteries = List(lotteryQuantity) { generateNumbers() }
        return LotteryTicket(lotteries)
    }

    private fun getQuantity(money: Money): Int = (money / LOTTERY_PRICE).scaleDown().toInt()

    private fun generateNumbers(): Lottery {
        val lotteryNumbers = Lottery.LOTTERY_NUMBER_RANGE.shuffled().take(6).toSet()
        return Lottery(lotteryNumbers)
    }
}
