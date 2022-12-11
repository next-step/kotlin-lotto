package lotto.domain

enum class Rank(val krw: KRW, val countOfMatch: Int) {
    FIRST(KRW(2000000000), 6),
    SECOND(KRW(150000), 5),
    THIRD(KRW(50000), 4),
    FOURTH(KRW(5000), 3),
    MISS(KRW(0), 0);

    companion object {
        fun valueOf(matchResult: MatchResult): Rank {
            return when (matchResult.countOfMatch) {
                FIRST.countOfMatch -> FIRST
                SECOND.countOfMatch -> SECOND
                THIRD.countOfMatch -> THIRD
                FOURTH.countOfMatch -> FOURTH
                else -> MISS
            }
        }
    }

    fun calculatePrize(count: Int): Int {
        return krw.money * count
    }
}
