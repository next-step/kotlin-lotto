
package lotto.domain

enum class LottoRank(val winningMoney: Int, val matchCount: Int) {
    FIRST(2_000_000_000, 6),
    SECOND_WITH_BONUS(30_000_000, 5),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3),
    MISS(0, 0);

    companion object {
        fun findByMatchCount(matchCount: Int): LottoRank {
            if (matchCount == 5) {
                return SECOND
            }

            return values().find { it.matchCount == matchCount } ?: MISS
        }
    }
}
