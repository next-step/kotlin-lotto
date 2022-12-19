package step2.domain

import kotlin.math.roundToInt

class Statistics(private val answerCount: List<Int>) {
    var matchThreeCount = 0
        private set
    var matchFourCount = 0
        private set
    var matchFiveCount = 0
        private set
    var matchSixCount = 0
        private set

    fun revenue(): Int {
        answerCount.forEach { count ->
            when (count) {
                WinningAmount.MATCH_THREE.count -> matchThreeCount++
                WinningAmount.MATCH_FOUR.count -> matchFourCount++
                WinningAmount.MATCH_FIVE.count -> matchFiveCount++
                WinningAmount.MATCH_SIX.count -> matchSixCount++
            }
        }

        return (matchThreeCount * WinningAmount.MATCH_THREE.reward)
            .plus(matchFourCount * WinningAmount.MATCH_FOUR.reward)
            .plus(matchFiveCount * WinningAmount.MATCH_FIVE.reward)
            .plus(matchSixCount * WinningAmount.MATCH_SIX.reward)
    }

    fun rateOfRevenue(revenue: Int, purchaseAmount: Int): Double {
        return ((revenue.toDouble() / purchaseAmount.toDouble()) * 100.0).roundToInt() / 100.0
    }

    fun matchResult(): Map<WinningAmount, Int> {
        return mapOf(
            WinningAmount.MATCH_THREE to matchThreeCount,
            WinningAmount.MATCH_FOUR to matchFourCount,
            WinningAmount.MATCH_FIVE to matchFiveCount,
            WinningAmount.MATCH_SIX to matchSixCount
        )
    }
}
