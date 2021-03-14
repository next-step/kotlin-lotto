package lotto.vo

import lotto.domain.LottoPrize

data class Winners(val winners: List<LottoPrize>) {
    fun getTotalPrizeMoney(): Int {
        return winners.sumBy { it.price }
    }
}
