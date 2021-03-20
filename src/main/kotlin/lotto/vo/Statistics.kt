package lotto.vo

import lotto.domain.LottoPrize

data class Statistics(val stats: Map<LottoPrize, Int>) : Map<LottoPrize, Int> by stats {
    fun getTotalPrizeMoney(): Int {
        return stats.toList().sumBy { it.first.price }
    }
}
