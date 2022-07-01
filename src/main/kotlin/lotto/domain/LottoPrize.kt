package lotto.domain

enum class LottoPrize(val rank: Int, val matchCount: Int, val prizeMoney: Money) {
    FIRST(1, 6, Money(2_000_000_000)),
    SECOND(2, 5, Money(30_000_000)),
    THIRD(3, 5, Money(1_500_000)),
    FOURTH(4, 4, Money(50_000)),
    FIFTH(5, 3, Money(5_000));
}
