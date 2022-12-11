package lotto.domain

enum class Rank(val krw: KRW, val countOfMatch: Int) {
    FIRST(KRW(2_000_000_000), 6),
    SECOND(KRW(30_000_000), 5),
    THIRD(KRW(1_500_000), 5),
    FOURTH(KRW(50_000), 4),
    FIFTH(KRW(5_000), 3),
    MISS(KRW(0), 0);

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
