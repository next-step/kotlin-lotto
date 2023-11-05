
package lotto.domain

enum class LottoRank(val winningMoney: Int, val matchCount: Int) {
    FIRST(2000000000, 6),
    SECOND(1500000, 5),
    THIRD(50000, 4),
    FOURTH(5000, 3),
    MISS(0, 0);

    companion object {
        fun findByMatchCount(matchCount: Int): LottoRank {
            return values().find { it.matchCount == matchCount } ?: MISS
        }
    }
}
