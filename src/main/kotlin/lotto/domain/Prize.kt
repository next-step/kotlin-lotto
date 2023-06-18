package lotto.domain

enum class Prize(val matchCount: Int, val amount: Int) {
    MATCH_3(3, 5000),
    MATCH_4(4, 50000),
    MATCH_5(5, 1500000),
    MATCH_6(6, 2000000000);

    companion object {
        fun prizeForMatchCount(matchCount: Int): Prize? {
            return values().find { it.matchCount == matchCount }
        }
    }
}
