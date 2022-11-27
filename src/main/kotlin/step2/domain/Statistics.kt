package step2.domain

class Statistics {

    fun matchCount(matchCount: List<Int>): Int {
        matchCount.forEach { count ->
            when (count) {
                3 -> matchThreeCount++
                4 -> matchFourCount++
                5 -> matchFiveCount++
                6 -> matchSixCount++
            }
        }

        return (matchThreeCount * WinningAmount.MATCH_THREE.value)
            .plus(matchFourCount * WinningAmount.MATCH_FOUR.value)
            .plus(matchFiveCount * WinningAmount.MATCH_FIVE.value)
            .plus(matchSixCount * WinningAmount.MATCH_SIX.value)
    }

    companion object {
        var matchThreeCount = 0
            private set
        var matchFourCount = 0
            private set
        var matchFiveCount = 0
            private set
        var matchSixCount = 0
            private set

        fun matchResult(): Map<WinningAmount, Int> {
            return mapOf(
                WinningAmount.MATCH_THREE to matchThreeCount,
                WinningAmount.MATCH_FOUR to matchFourCount,
                WinningAmount.MATCH_FIVE to matchFiveCount,
                WinningAmount.MATCH_SIX to matchSixCount
            )
        }
    }
}
