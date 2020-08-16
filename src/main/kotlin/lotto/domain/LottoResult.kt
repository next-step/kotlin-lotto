package lotto.domain

import java.math.BigDecimal

class LottoResult(private val result: Map<Rank, Int>) {
    fun countByRank(rank: Rank): Int {
        return result.getOrDefault(rank, DEFAULT_VALUE)
    }

    fun calculateTotalRate(money: Money): BigDecimal {
        return calculateTotalPrize().div(money)
    }

    private fun calculateTotalPrize(): Money {
        return result.map { it.key.prizeByCount(it.value) }.reduce(Money::plus)
    }

    companion object {
        private const val DEFAULT_VALUE = 0
    }
}
