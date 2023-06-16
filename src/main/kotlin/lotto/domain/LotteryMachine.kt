package lotto.domain

import java.math.RoundingMode

object LotteryMachine {
    private val LOTTERY_PRICE = Money(1_000)
    private const val QUANTITY_SCALE = 0

    fun issueLotteryTicket(money: Money): LotteryTicket {
        val lotteryQuantity = getQuantity(money)
        val lotteries = mutableListOf<Lottery>()
        repeat(lotteryQuantity.toInt()) {
            lotteries.add(generateNumbers())
        }
        return LotteryTicket(lotteries)
    }

    private fun getQuantity(money: Money) =
        ((money / LOTTERY_PRICE).setScale(QUANTITY_SCALE, RoundingMode.FLOOR).toLong())

    private fun generateNumbers(): Lottery {
        val lotteryNumbers = mutableSetOf<Int>()
        while (lotteryNumbers.size < Lottery.LOTTERY_NUMBER_SIZE) {
            Lottery.LOTTERY_NUMBER_RANGE.shuffled().take(6).toSet()
            val randomNum = Lottery.LOTTERY_NUMBER_RANGE.random()
            if (randomNum !in lotteryNumbers) {
                lotteryNumbers.add(randomNum)
            }
        }
        return Lottery(lotteryNumbers)
    }
}
