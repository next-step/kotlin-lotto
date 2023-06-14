package lotto.domain

import lotto.model.LottoErrorCode

@JvmInline
value class LottoMatchResult(private val countOfMatch: Int) {

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
