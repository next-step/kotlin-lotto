package lotto.domain

@JvmInline
value class MatchedCount private constructor(val value: Int) {
    companion object {
        private const val MINIMUM_MATCHED_COUNT = 0
        private const val MAXIMUM_MATCHED_COUNT = 6
        private const val MATCHED_COUNT_TO_CHECK_BONUS_NUMBER = 5
        private const val WRONG_MATCHED_COUNT_ENTERED_MESSAGE = "잘못된 숫자 일치 개수입니다."

        fun of(value: Int): MatchedCount {
            return matchedCountPool[value]
        }

        private val matchedCountPool = IntRange(MINIMUM_MATCHED_COUNT, MAXIMUM_MATCHED_COUNT)
            .map { MatchedCount(it) }
            .toList()

        operator fun get(index: Int): MatchedCount {
            require(index in MINIMUM_MATCHED_COUNT..MAXIMUM_MATCHED_COUNT) { WRONG_MATCHED_COUNT_ENTERED_MESSAGE }
            return matchedCountPool[index]
        }
    }

    fun shouldCheckBonusNumber(): Boolean {
        return value == MATCHED_COUNT_TO_CHECK_BONUS_NUMBER
    }
}
