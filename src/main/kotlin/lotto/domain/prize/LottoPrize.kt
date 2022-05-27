package lotto.domain.prize

enum class LottoPrize(val numberOfMatches: Int, val prizeAmount: Int) {
    SIX_MATCHES(6, 2000000000),
    FIVE_MATCHES(5, 1500000),
    FOUR_MATCHES(4, 50000),
    THREE_MATCHES(3, 5000),
    MISS(0, 0);

    companion object {
        fun of(numberOfMatches: Int) = values().find { it.numberOfMatches == numberOfMatches } ?: MISS
    }
}
