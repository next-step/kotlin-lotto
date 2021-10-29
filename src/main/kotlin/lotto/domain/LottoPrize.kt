package lotto.domain

enum class LottoPrize(val matchingNumberCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FORTH(3, 5_000),
    TWO(2, 0),
    ONE(1, 0),
    ZERO(0, 0);

    companion object {
        fun toList(): List<LottoPrize> = values().toList()
    }
}
