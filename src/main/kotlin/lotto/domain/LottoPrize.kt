package lotto.domain

enum class LottoPrize(val matchedCount: Int, val money: Int, val matchedBonus: Boolean) {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false),
    ;

    companion object {
        fun getPrize(matchedCount: Int, bonus: Boolean): LottoPrize =
            values().filter { bonus == it.matchedBonus }
                .firstOrNull { matchedCount == it.matchedCount } ?: MISS
    }
}
