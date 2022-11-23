package lotto.domain

import kotlin.math.floor

class LottoStatistics(private val countOfMatchResult: List<Int>, private val amount: Int) {
    val matchesResult: Map<Rank, Int> = initMatchesResult()

    private fun initMatchesResult(): Map<Rank, Int> {
        return Rank.values().associateWith { rule ->
            countOfMatchResult.count { it == rule.countOfMatch }
        }
    }

    var rateOfReward: Double = calculateTotalProfit()
        private set

    private fun calculateTotalProfit(): Double {
        val reward = matchesResult.map { it.key.getTotalWinningMoney(it.value) }.sum().toDouble()
        return floor(reward / amount * 100) / 100
    }
}
