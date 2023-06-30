package lotto.domain

enum class Rank(
    val matchCount: Int,
    val prize: Long
) {
    MISS(0, 0),
    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    companion object {
        private const val MATCH_COUNT_ERROR_MESSAGE = "matchCount는 0이상 6이하만 가능합니다."
        fun of(matchCount: Int): Rank {
            require(matchCount in 0..6) { MATCH_COUNT_ERROR_MESSAGE }

            return Rank from matchCount
        }
        private val map = Rank.values().associateBy { it.matchCount }
        private infix fun from(matchCount: Int): Rank = map[matchCount] ?: MISS
    }
}
