package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val reward: Long
) {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000);

    companion object {
        private const val DEFAULT_REWARD = 0L

        fun getReward(matchCount: Int): Long =
            values().firstOrNull { it.matchCount == matchCount }
                ?.reward
                ?: DEFAULT_REWARD

        fun getMatchCountList(): List<Int> =
            values().map { it.matchCount }
    }
}
