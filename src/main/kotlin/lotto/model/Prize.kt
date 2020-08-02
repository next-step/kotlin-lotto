package lotto.model

enum class Prize(val matchCount: Int, val price: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NOTHING(0, 0);

    companion object {
        fun findByMatchCount(matchCount: Int): Prize =
            values().firstOrNull { it.matchCount == matchCount } ?: NOTHING
    }
}
