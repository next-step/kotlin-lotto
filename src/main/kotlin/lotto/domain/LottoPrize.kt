package lotto.domain

enum class LottoPrize(val matchingCount: Int, value: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    val amount: Amount = Amount(value)

    companion object {
        fun from(matchingCount: Int): LottoPrize = values().find { it.matchingCount == matchingCount } ?: MISS
    }
}
