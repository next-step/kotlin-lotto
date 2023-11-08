package lotto.domain

enum class Prize(
    val matchedNumberCount: Int,
    val winningAmount: Long,
) {
    FIRST(6, 2000000000L),
    SECOND(5, 30000000L),
    THIRD(5, 1500000L),
    FOURTH(4, 50000L),
    FIFTH(3, 5000L),
    ;

    companion object {
        private const val ONE_NOT_MATCHED = 5

        fun valueOfOrNull(matchedNumberCount: Int, bonusNumberMatch: Boolean): Prize? {
            if (matchedNumberCount == ONE_NOT_MATCHED) {
                if (bonusNumberMatch) {
                    return SECOND
                }
                return THIRD
            }

            return Prize.values()
                .find { it.matchedNumberCount == matchedNumberCount }
        }
    }
}
