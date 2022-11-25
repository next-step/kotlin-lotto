package lotto.domain

import lotto.dto.MatchResultDto
import kotlin.math.floor

class LottoStatistics(private val countOfMatchResult: List<MatchResultDto>, amount: Int) {
    val matchResult: Map<Rank, Int> = initMatchResult()

    private fun initMatchResult(): Map<Rank, Int> {
        return Rank.values().associateWith { rule ->
            when (rule) {
                Rank.SECOND -> countOfMatchResult.count { it.countOfMatch == rule.countOfMatch && it.matchBonus }
                Rank.THIRD -> countOfMatchResult.count { it.countOfMatch == rule.countOfMatch && !it.matchBonus }
                else -> countOfMatchResult.count { it.countOfMatch == rule.countOfMatch }
            }
        }
    }

    var rateOfReward: Double = calculateTotalProfit(amount)
        private set

    private fun calculateTotalProfit(amount: Int): Double {
        val reward = matchResult.map { it.key.getTotalWinningMoney(it.value) }.sum().toDouble()
        return floor(reward / amount * 100) / 100
    }
}
