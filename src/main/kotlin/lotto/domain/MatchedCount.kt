package lotto.domain

@JvmInline
value class MatchedCount private constructor(val value: Int) {
    companion object {
        private const val MINIMUM_MATCHED_COUNT = 0
        private const val MAXIMUM_MATCHED_COUNT = 6
        private const val WRONG_MATCHED_COUNT_ENTERED_MESSAGE = "잘못된 숫자 일치 개수입니다."

        fun from(value: Int): MatchedCount {
            require(value in MINIMUM_MATCHED_COUNT..MAXIMUM_MATCHED_COUNT) { WRONG_MATCHED_COUNT_ENTERED_MESSAGE }
            return MatchedCount(value)
        }
    }

    fun getRank() : LottoResultRank {
        return LottoResultRank.getRank(value)
    }
}
