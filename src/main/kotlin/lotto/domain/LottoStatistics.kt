package lotto.domain

import java.math.BigDecimal
import java.math.MathContext

typealias MatchCount = Int

data class LottoStatistics(
    private val statistics: Map<LottoMatch, MatchCount>
) : Map<LottoMatch, MatchCount> by statistics {

    private val ticketCount: Int = values.sum()

    fun getProfit(): BigDecimal {
        require(ticketCount > 0)
        val purchase = ticketCount * LottoStore.PRICE_OF_ONE_LOTTO_TICKET
        return getRewards().divide(purchase.toBigDecimal(), MathContext.DECIMAL32)
    }

    private fun getRewards(): BigDecimal {
        return filterValues { count -> count > 0 }
            .map { it.key.reward.toBigDecimal() * it.value.toBigDecimal() }
            .sumOf { it }
    }
}
