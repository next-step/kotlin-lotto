package lotto.domain

enum class LottoRank(val matchingCount: Int, val matchBonus: Boolean, val reward: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    UNRANKED(-1, false, 0);

    companion object {
        fun valueOf(matchingCount: Int, matchBonus: Boolean): LottoRank {
            return values().find { it.matchingCount == matchingCount && it.matchBonus == matchBonus } ?: UNRANKED
        }
    }
}
