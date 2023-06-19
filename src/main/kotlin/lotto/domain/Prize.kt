package lotto.domain

enum class Prize(val matchCount: Int, val amount: Int) {
    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1500000),
    SIXTH(6, 2000000000);

    companion object {
        fun prizeForMatchCount(matchCount: Int): Prize? {
            return values().find { it.matchCount == matchCount }
        }
    }
}
