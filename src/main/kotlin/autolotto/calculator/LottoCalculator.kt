package autolotto.calculator

import autolotto.enums.prize.Prize
import kotlin.math.round

object LottoCalculator {
    private const val ZERO = 0
    private const val ONE_HUNDRED = 100
    fun getTotalPrize(
        lotto: Map<Int, Int>
    ): Int {
        return lotto.map { (number, count) -> getPrize(number, count) }.sum()
    }

    private fun getPrize(number: Int, count: Int): Int {
        val prize = Prize.fromMatchCount(number)
        return prize?.calculatePrize(count) ?: ZERO
    }


    fun getProfitRate(totalPrize: Int, amount: Int): Double {
        return round(
            totalPrize /
                    (totalPrize - amount).toDouble() * ONE_HUNDRED
        ) / ONE_HUNDRED
    }
}