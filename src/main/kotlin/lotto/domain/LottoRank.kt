package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val reward: Long,
    val isBonus: Boolean
) {
    FIFTH_PLACE(3, 5000, false),
    FOURTH_PLACE(4, 50000, false),
    THIRD_PLACE(5, 1500000, false),
    SECOND_PLACE(5, 30000000, true),
    FIRST_PLACE(6, 2000000000, false);

    companion object {
        fun valueOf(matchCount: Int, isBonus: Boolean): LottoRank? =
            values().find {
                it.matchCount == matchCount && it.isBonus == isBonus
            }
    }
}
