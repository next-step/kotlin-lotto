package lotto.model

enum class Prize(val matchingCount: Int, val prizeMoney: Int) {
    ONE(6, 2_000_000_000),
    TWO(5, 1_500_000),
    THREE(4, 50_000),
    FOUR(3, 5_000),
    ZERO(0, 0);

    companion object {
        fun getPrize(matchingCount: Int) = values().find { it.matchingCount == matchingCount } ?: ZERO
    }
}
