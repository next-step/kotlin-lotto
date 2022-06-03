package lotto.domain

enum class LottoMatchType(val matchCount: Int, val reward: Long, val isBonus: Boolean = false) {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000, true),
    SIX(6, 2_000_000_000)
}
