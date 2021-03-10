package lotto.model

enum class Coincidence(val coincidenceCount: Int, val prizeMoney: Int, val hasBonusNum: Boolean) {
    THREE(3, 5_000, false),
    FOUR(4, 50_000, false),
    FIVE(5, 1_500_000, false),
    FIVE_WITH_BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000, false);
}
