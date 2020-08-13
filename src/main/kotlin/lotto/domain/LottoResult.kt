package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoResult(private val result: Map<Rank, Int>) {
    fun countByRank(rank: Rank): Int {
        return result.getOrDefault(rank, DEFAULT_VALUE)
    }

    fun calculateTotalRate(money: Money): BigDecimal {
        return calculateTotalPrize().toBigDecimal().divide(money.toBigDecimal(), SCALE_VALUE, RoundingMode.HALF_EVEN)
    }

    private fun calculateTotalPrize(): Money {
        return result.keys.map { it.prizeByCount(result.getValue(it)) }.reduce { total, money -> total + money }
    }

    companion object {
        private const val DEFAULT_VALUE = 0
        private const val SCALE_VALUE = 0
    }
}
