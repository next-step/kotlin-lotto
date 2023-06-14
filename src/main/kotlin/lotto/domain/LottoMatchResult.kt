package lotto.domain

import lotto.model.LottoErrorCode

class LottoMatchResult(
    private val countOfMatch: Int,
    private vararg val bonusMatchStates: MatchState = arrayOf(MatchState.MATCH, MatchState.NON_MATCH),
) {

    init {
        check(value = countOfMatch in RANGE_COUNT_OF_MATCH) {
            LottoErrorCode.NOT_INCLUDE_RANGE_COUNT_OF_MATCH.message("$RANGE_COUNT_OF_MATCH $countOfMatch")
        }
    }

    fun correctMatchResult(otherMatchResult: LottoMatchResult): Boolean = when {
        this.countOfMatch != otherMatchResult.countOfMatch -> false
        this.bonusMatchStates.any { it in otherMatchResult.bonusMatchStates }.not() -> false
        else -> true
    }

    fun hasBonusBallCondition(): Boolean = when {
        this.bonusMatchStates.all { it == MatchState.MATCH } -> true
        else -> false
    }

    override fun toString(): String = countOfMatch.toString()

    companion object {
        private val RANGE_COUNT_OF_MATCH: IntRange = 0..6
    }
}
