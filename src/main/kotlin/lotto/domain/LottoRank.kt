package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val reward: Long,
    val isBonus: Boolean
) {
    FIFTH_PLACE(3, 5000L, false),
    FOURTH_PLACE(4, 50000L, false),
    THIRD_PLACE(5, 1_500_000L, false),
    SECOND_PLACE(5, 30_000_000L, true),
    FIRST_PLACE(6, 2_000_000_000L, false);

    companion object {
        fun valueOf(matchCount: Int, isBonus: Boolean): LottoRank? =
            values().find {
                it.matchCount == matchCount && it.isBonus == isBonus
            }
    }
}
