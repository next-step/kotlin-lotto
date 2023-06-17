package next.step.lotto.domain

enum class LottoRank(val matchCount: Int, val winnings: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {

        fun from(matchCount: Int, matchBonus: Boolean): LottoRank =
            if (isBonusRank(matchCount, matchBonus)) SECOND else withoutBonus(matchCount)

        private fun isBonusRank(matchCount: Int, matchBonus: Boolean) = matchCount == SECOND.matchCount && matchBonus

        private fun withoutBonus(matchCount: Int) =
            values().filter { it != SECOND }.find { it.matchCount == matchCount } ?: MISS
    }

}