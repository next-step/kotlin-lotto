package lotto.domain

enum class LottoRank(val num: Int, val price: Int) {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_WITH_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    companion object {
        fun of(num: Int, hasBonusNumber: Boolean): LottoRank? {
            return when {
                num == 5 && hasBonusNumber -> FIVE_WITH_BONUS
                num == 5 -> FIVE
                else -> LottoRank.values().find { it.num == num }
            }
        }
    }
}
