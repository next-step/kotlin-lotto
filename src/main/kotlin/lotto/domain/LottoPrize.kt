package lotto.domain

enum class LottoPrize(val matchedCount: Int, val money: Int) {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0),
    ;

    companion object {
        fun getPrize(matchedCount: Int): LottoPrize = values().firstOrNull { matchedCount == it.matchedCount } ?: MISS
    }
}
