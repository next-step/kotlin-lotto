package lotto.domain

enum class Rank(
    val matchCount: Int,
    val prize: Long
) {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    companion object {
        private const val MATCH_COUNT_ERROR_MESSAGE = "matchCount는 0이상 6이하만 가능합니다."
        fun of(matchCount: Int, isBonus: Boolean = false): Rank {
            require(matchCount in 0..6) { MATCH_COUNT_ERROR_MESSAGE }

            return rank(matchCount, isBonus)
        }

        private fun rank(matchCount: Int, isBonus: Boolean): Rank {
            if (matchCount == 5) {
                if (isBonus) return SECOND
                return THIRD
            }

            return Rank.values().firstOrNull { it.matchCount == matchCount } ?: MISS
        }
    }
}
