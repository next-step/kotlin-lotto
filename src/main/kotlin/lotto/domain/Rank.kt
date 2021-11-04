package lotto.domain

enum class Rank(
    val matchCount: Int,
    val reward: Long,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    BLANK(0, 0);

    companion object {
        private const val FIVE_MATCH = 5

        fun findBy(
            matchCount: Int,
            isMatchedBonusNumber: Boolean,
        ): Rank {
            if (matchCount == FIVE_MATCH && !isMatchedBonusNumber) {
                return THIRD
            }

            return values().find { rank ->
                rank.matchCount == matchCount
            } ?: BLANK
        }
    }
}
