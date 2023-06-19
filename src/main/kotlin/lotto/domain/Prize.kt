package lotto.domain

enum class Prize(val matchCount: Int, val amount: Int) {
    THIRD_PLACE(3, 5_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(5, 1_500_000),
    WIN(6, 2_000_000_000);

    companion object {
        fun prizeForMatchCount(matchCount: Int): Prize? {
            return values().find { it.matchCount == matchCount }
        }
    }
}
