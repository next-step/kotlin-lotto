package lotto.domain

enum class LottoRank(val num: Int, val price: Int) {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun of(num: Int, hasBonusNumber: Boolean): LottoRank? {
            return when {
                num == 5 && hasBonusNumber -> SECOND
                num == 5 -> THIRD
                else -> LottoRank.values().find { it.num == num }
            }
        }
    }
}
