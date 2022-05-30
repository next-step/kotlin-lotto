package lotto

enum class LottoPrize(val matchCount: Int, val price: Int) {
    NONE(0, 0),
    FIRST(1, 0),
    SECOND(2, 0),
    THIRD(3, 5_000),
    FORTH(4, 50_000),
    FIFTH(5, 1_500_000),
    FIFTH_BONUS(6, 30_000_000),
    SIXTH(6, 2_000_000_000);

    companion object {

        fun of(matchCount: Int, matchBonus: Boolean): LottoPrize {
            return if (matchBonus) {
                FIFTH_BONUS
            } else {
                values().filter { it != FIFTH_BONUS }.firstOrNull { it.matchCount == matchCount }
            } ?: NONE
        }
    }
}
