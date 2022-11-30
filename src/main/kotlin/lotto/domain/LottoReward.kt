package lotto.domain

enum class LottoReward(val matchCount: Int, val rewardPrice: Int) {
    MATCH_THREE(3, 5000),
    MATCH_FOUR(4, 50000),
    MATCH_FIVE(5, 1500000),
    MATCH_SIX(6, 2000000000);

    companion object {
        fun find(input: Int) = values().find { it.matchCount == input }
            ?: throw RuntimeException("상금을 받을 수 없습니다.")
    }
}