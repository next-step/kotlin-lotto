package lotto.domain

enum class LottoPrize(val rank: Int, val matchCount: Int, val prizeMoney: Int) {
    FIRST(1, 6, 2_000_000_000),
    SECOND(2, 5, 30_000_000),
    THIRD(3, 5, 1_500_000),
    FOURTH(4, 4, 50_000),
    FIFTH(5, 3, 5_000);
}
