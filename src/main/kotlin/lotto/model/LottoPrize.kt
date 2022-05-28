package lotto.model

enum class LottoPrize(val matchCount: Int, val prizeMoney: Int) {
    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 150000),
    SIX_MATCH(6, 2000000000);

    companion object {
        fun find(matchCount: Int) = values().find { it.matchCount == matchCount }
    }
}
