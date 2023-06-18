package lotto.domain

import kotlin.math.floor

class RateOfReturn(ranking: Ranking, amount: Int) {
    val rate: Double
        get() = floor(field * 100) / 100
    init {
        rate = ranking.totalWinAmount.toDouble() / amount.toDouble()
    }
}
