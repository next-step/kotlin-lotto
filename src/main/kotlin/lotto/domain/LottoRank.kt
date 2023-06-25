package lotto.domain

enum class LottoRank(
    val countOfMatch: Int?,
    val price: Int
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun getLottoRankByMatchCount(countOfMatch: Int, matchBonus: Boolean): LottoRank {
            if (SECOND.countOfMatch == countOfMatch && matchBonus) {
                return SECOND
            }
            if (SECOND.countOfMatch == countOfMatch && !matchBonus) {
                return THIRD
            }
            return values().find { it.countOfMatch == countOfMatch } ?: MISS
        }
    }
}
