package lotto.domain

enum class Prize(val matchCount: Int, val amount: Int) {
    NO_PRIZE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    companion object {
        fun prizeForMatchCount(matchCount: Int): Prize {
            return values().find { it.matchCount == matchCount } ?: NO_PRIZE
        }
    }
}
