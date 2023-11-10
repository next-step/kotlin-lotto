package lotto.domain

enum class LottoReward(val matchCount: Int, val reward: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000);

    companion object {
        fun valueOf(matchCount: Int): LottoReward? =
            values().find { it.matchCount == matchCount }
    }
}
