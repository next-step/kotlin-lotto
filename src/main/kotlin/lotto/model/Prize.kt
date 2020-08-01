package lotto.model

enum class Prize(val matchCount: Int, val price: Int) {
    NO_ONE(6, 2_000_000_000),
    NO_TWO(5, 1_500_000),
    NO_THREE(4, 50_000),
    NO_FOUR(3, 5_000),
    NOTHING(0, 0);

    companion object {
        fun findByMatchCount(matchCount: Int): Prize =
            values().firstOrNull { it.matchCount == matchCount } ?: NOTHING
    }
}
