package lotto

import java.math.BigDecimal

data class LottoStatistics(private val ranks: Ranks, private val amount: Amount) {
    fun machRankCount(rank: Rank): Int {
        return ranks.count(rank)
    }

    fun rate(): BigDecimal {
        return ranks.rate(amount)
    }

    fun isLoss(): Boolean {
        return rate() < BigDecimal.ONE
    }
}
