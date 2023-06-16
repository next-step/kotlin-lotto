package lotto.domain

import lotto.model.LottoErrorCode

data class LottoMatchResult(
    val countOfMatch: Int,
    val mustBonusMatch: Boolean = false,
) {

    init {
        check(value = countOfMatch in RANGE_COUNT_OF_MATCH) {
            LottoErrorCode.NOT_INCLUDE_RANGE_COUNT_OF_MATCH.message("$RANGE_COUNT_OF_MATCH $countOfMatch")
        }
    }

    override fun toString(): String = countOfMatch.toString()

    companion object {
        private val RANGE_COUNT_OF_MATCH: IntRange = 0..6
    }
}
