package lotto.domain

enum class Rank(val krw: KRW, val countOfMatch: Int, val matchBonus: Boolean = false) {
    FIRST(KRW(2_000_000_000), 6),
    SECOND(KRW(30_000_000), 5, true),
    THIRD(KRW(1_500_000), 5),
    FOURTH(KRW(50_000), 4),
    FIFTH(KRW(5_000), 3),
    MISS(KRW(0), 0);

    companion object {
        fun valueOf(matchResult: MatchResult): Rank {
            if (matchResult.countOfMatch == SECOND.countOfMatch && matchResult.matchBonus == SECOND.matchBonus) {
                return SECOND
            }
            return when {
                (matchResult.countOfMatch == FIRST.countOfMatch) -> FIRST
                (matchResult.countOfMatch == THIRD.countOfMatch) -> THIRD
                (matchResult.countOfMatch == FOURTH.countOfMatch) -> FOURTH
                (matchResult.countOfMatch == FIFTH.countOfMatch) -> FIFTH
                else -> MISS
            }
        }
    }

    fun calculatePrize(count: Int): Int {
        return krw.money * count
    }
}
