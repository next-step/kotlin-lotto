package lotto.domain.matching

enum class LottoMatching(val matchingCount: Int) {
    FIRST_PLACE_MATCHING(6),
    SECOND_PLACE_MATCHING(5),
    THIRD_PLACE_MATCHING(4),
    FOURTH_PLACE_MATCHING(3),
    LAST_PLACE_MATCHING(0);

    companion object {
        private const val MIN_MATCHING_COUNT = 0
        private const val MAX_MATCHING_COUNT = 6
        const val ERR_INVALID_MATCHING_COUNT =
            "[ERROR] The given matching count must be in the range $MIN_MATCHING_COUNT to $MAX_MATCHING_COUNT"

        private val matchingCountMap = values().associateBy { it.matchingCount }

        fun from(matchingCount: Int): LottoMatching = matchingCountMap[matchingCount]
            ?: run {
                if (matchingCount in 0..2) {
                    return LAST_PLACE_MATCHING
                }

                throw IllegalArgumentException(ERR_INVALID_MATCHING_COUNT)
            }
    }
}
