package lotto.domain

enum class LottoPrize(val matchCount: Int, val prizeMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    companion object {
        fun find(matchCount: Int): LottoPrize? = values().find { it.matchCount == matchCount }
    }
}
