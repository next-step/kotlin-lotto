package lotto.domain

enum class LottoMatch(val count: Int, val withBonus: Boolean, val reward: Long) {
    THREE(3, false, 5_000),
    FOUR(4, false, 50_000),
    FIVE(5, false, 1_500_000),
    FIVE_BONUS(5, true, 30_000_000),
    SIX(6, false, 2_000_000_000)
}
