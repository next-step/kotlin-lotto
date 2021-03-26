package lotto.domain

enum class LottoRank(val matchCount: Int, val winningPrice: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    FAIL(0, 0);

    companion object {
        fun matchRank(matchCount: Int, matchBonus: Boolean): LottoRank {
            val rank = values().find {
                it.matchCount == matchCount
            } ?: FAIL
            if (rank.matchCount == SECOND.matchCount && matchBonus) return SECOND
            if (rank.matchCount == THIRD.matchCount && !matchBonus) return THIRD
            return rank
        }
    }
}
