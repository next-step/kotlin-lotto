package autolotto.calculator

import kotlin.math.round

object LottoCalculator {
    private val FOUR_PRIZE_MONEY = 5000
    private val THREE_PRIZE_MONEY = 50000
    private val SECOND_PRIZE_MONEY = 1500000
    private val FIRST_PRIZE_MONEY = 2000000000

    fun getTotalPrize(
        lotto: Map<Int, Int>
    ): Int {
        return lotto.map { (number, count) -> getPrize(number, count) }.sum()
    }

    private fun getPrize(
        number: Int,
        count: Int,
    ): Int {
        var totalPrize = 0
        when (number) {
            3 -> totalPrize = count * FOUR_PRIZE_MONEY
            4 -> totalPrize = count * THREE_PRIZE_MONEY
            5 -> totalPrize = count * SECOND_PRIZE_MONEY
            6 -> totalPrize = count * FIRST_PRIZE_MONEY
        }
        return totalPrize
    }

    fun getProfitRate(totalPrize: Int, amount: Int): Double {
        return round(
            totalPrize /
                    (totalPrize - amount).toDouble() * 100
        ) / 100
    }


}