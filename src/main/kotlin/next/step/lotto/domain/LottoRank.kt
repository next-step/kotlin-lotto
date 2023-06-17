package next.step.lotto.domain

enum class LottoRank(val matchCount: Int, val winnings: Int, val matchBonus: Boolean = false) {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    companion object {

        fun from(matchCount: Int, matchBonus: Boolean): LottoRank =
            values().filter { it.matchBonus == matchBonus }.find { it.matchCount == matchCount }
                ?: (values().find { it.matchCount == matchCount } ?: MISS)
    }

}
