package lotto.domain

enum class Rank(val krw: KRW, val countOfMatch: Int, val matchBonus: Boolean) {
    FIRST(KRW(2_000_000_000), 6, false),
    SECOND(KRW(30_000_000), 5, true),
    THIRD(KRW(1_500_000), 5, false),
    FOURTH(KRW(50_000), 4, false),
    FIFTH(KRW(5_000), 3, false),
    MISS(KRW(0), 0, false);

    companion object {
        fun valueOf(matchResult: MatchResult): Rank {
            return when {
                (matchResult.countOfMatch == FIRST.countOfMatch) -> FIRST
                (matchResult.countOfMatch == SECOND.countOfMatch) && matchResult.matchBonus -> SECOND
                (matchResult.countOfMatch == SECOND.countOfMatch) && !matchResult.matchBonus -> THIRD
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
