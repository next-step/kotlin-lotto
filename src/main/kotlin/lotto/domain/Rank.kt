package lotto.domain

enum class Rank(
    val matchCount: Int,
    val winningMoney: Int,
) {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    ;

    companion object {
        private val MAP_BY_MATCH_COUNT = values().associateBy { it.matchCount }

        fun of(matchCount: Int): Rank {
            return MAP_BY_MATCH_COUNT[matchCount]
                ?: throw IllegalArgumentException("일치하는 순위가 없습니다.")
        }
    }
}
