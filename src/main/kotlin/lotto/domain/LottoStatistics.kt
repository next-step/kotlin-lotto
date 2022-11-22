package lotto.domain

import kotlin.math.floor

class LottoStatistics(private val matchesCountResult: List<Int>, private val amount: Int) {
    val matchesResult: Map<LottoRule, Int> = initMatchesResult()

    private fun initMatchesResult(): Map<LottoRule, Int> {
        return LottoRule.values().associateWith { rule ->
            matchesCountResult.count { matchesCount -> matchesCount == rule.matchesCount }
        }
    }

    var rateOfReward: Double = calculateTotalPofit()
        private set

    private fun calculateTotalPofit(): Double {
        var reward = matchesResult.map { result -> result.key.getTotalReward(result.value) }.sum().toDouble()
        return floor(reward / amount * 100) / 100
    }
}
