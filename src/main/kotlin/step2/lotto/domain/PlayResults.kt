package step2.lotto.domain

class PlayResults {
    var elements: MutableList<PlayResult> = mutableListOf()
        private set

    var firstPlaceCount = INITIAL_COUNT
        private set
    var secondPlaceCount = INITIAL_COUNT
        private set
    var thirdPlaceCount = INITIAL_COUNT
        private set
    var fourthPlaceCount = INITIAL_COUNT
        private set
    var notWinningCount = INITIAL_COUNT
        private set
    var totalReward: Long = INITIAL_COUNT.toLong()
        private set

    fun add(lotto: Lotto, matchResult: MatchResult) {
        elements.add(PlayResult.of(lotto, matchResult))
        recordRank(matchResult)
        addReward(matchResult)
    }

    private fun recordRank(matchResult: MatchResult) {
        when (matchResult) {
            MatchResult.FIRST_PLACE -> firstPlaceCount++
            MatchResult.SECOND_PLACE -> secondPlaceCount++
            MatchResult.THIRD_PLACE -> thirdPlaceCount++
            MatchResult.FOURTH_PLACE -> fourthPlaceCount++
            else -> notWinningCount++
        }
    }

    private fun addReward(matchResult: MatchResult) {
        totalReward += matchResult.reward
    }

    fun calculateProfitRate(buyAmount: Int): Double = totalReward / buyAmount.toDouble()

    companion object {
        private const val INITIAL_COUNT: Int = 0
    }
}
