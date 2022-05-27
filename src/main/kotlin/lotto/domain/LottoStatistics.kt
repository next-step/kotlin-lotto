package lotto.domain

import java.math.BigDecimal
import java.math.MathContext

typealias MatchCount = Int

class LottoStatistics(private val statistics: Map<LottoMatch, MatchCount>) : Map<LottoMatch, Int> by statistics {

    fun getProfit(purchase: Int): BigDecimal {
        require(purchase > 0)
        return getRewards().divide(purchase.toBigDecimal(), MathContext.DECIMAL128)
    }

    private fun getRewards(): BigDecimal {
        return filterValues { count -> count > 0 }
            .map { it.key.reward.toBigDecimal() * it.value.toBigDecimal() }
            .sumOf { it }
    }
}
