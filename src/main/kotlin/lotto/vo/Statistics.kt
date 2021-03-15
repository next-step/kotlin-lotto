package lotto.vo

import lotto.domain.LottoPrize

data class Statistics(val stats: Map<LottoPrize, Int>) {
    fun getTotalPrizeMoney(): Int {
        return stats.toList().sumBy { it.first.price }
    }
}
