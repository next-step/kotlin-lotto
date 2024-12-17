package lotto.calculator

import lotto.enums.prize.Prize
import kotlin.math.round

object LottoCalculator {
    private const val PERCENT_SCALE = 100

    fun getTotalPrize(lotto: Map<Prize, Int>): Int {
        return lotto.map { (prize, count) -> getPrize(prize, count) }.sum()
    }

    private fun getPrize(
        prize: Prize,
        count: Int,
    ): Int {
        return prize.calculatePrize(count)
    }

    fun getProfitRate(
        totalPrize: Int,
        amount: Int,
    ): Double {
        return round(
            totalPrize /
                (totalPrize - amount).toDouble() * PERCENT_SCALE,
        ) / PERCENT_SCALE
    }
}
