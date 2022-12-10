package step2.lotto.domain

class MatchResults() {
    private var elements: MutableList<MatchResult> = mutableListOf()
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

    fun add(matchResult: MatchResult) {
        recordScore(matchResult)
        elements.add(matchResult)
    }

    private fun recordScore(matchResult: MatchResult) {
        when (matchResult) {
            MatchResult.FIRST_PLACE -> firstPlaceCount++
            MatchResult.SECOND_PLACE -> secondPlaceCount++
            MatchResult.THIRD_PLACE -> thirdPlaceCount++
            MatchResult.FOURTH_PLACE -> fourthPlaceCount++
            else -> notWinningCount++
        }
    }

    fun contains(matchResult: MatchResult): Boolean = elements.contains(matchResult)

    fun containsAll(vararg matchResult: MatchResult): Boolean =
        elements.containsAll(matchResult.toList())

    companion object {
        private const val INITIAL_COUNT: Int = 0
    }
}
