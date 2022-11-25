package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val reward: Long
) {
    FOURTH_PLACE(3, 5000),
    THIRD_PLACE(4, 50000),
    SECOND_PLACE(5, 1500000),
    FIRST_PLACE(6, 2000000000);

    companion object {
        private const val DEFAULT_REWARD = 0L

        fun valueOf(matchCount: Int): LottoRank? =
            values().find {
                it.matchCount == matchCount
            }

        fun getReward(matchCount: Int): Long =
            values().firstOrNull { it.matchCount == matchCount }
                ?.reward
                ?: DEFAULT_REWARD

        fun getMatchCountList(): List<Int> =
            values().map { it.matchCount }
    }
}
