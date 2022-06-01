package lotto.domain

enum class LottoMatchType(val matchCount: Int, val isBonus: Boolean, val reward: Long) {
    THREE(3, false, 5000),
    FOUR(4, false, 50000),
    FIVE(5, false, 1500000),
    FIVE_BONUS(5, true, 30000000),
    SIX(6, false, 2000000000)
}
