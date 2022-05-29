package lotto.domain

enum class LottoPrize(val matchCount: Int, val prizeMoney: Int) {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 150_000),
    SIX_MATCH(6, 2_000_000_000);

    companion object {
        fun find(matchCount: Int) = values().find { it.matchCount == matchCount }
    }
}
