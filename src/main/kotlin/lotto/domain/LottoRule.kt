package lotto.domain

enum class LottoRule(val matchesCount: Int, val reward: Int) {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    LAST_PLACE(3, 5000);

    fun getTotalReward(count: Int): Int = count * reward

    companion object {
        fun ofMatchesCount(matchesCount: Int): LottoRule = values().first { rule -> rule.matchesCount == matchesCount }
    }
}
