package lotto.domain

enum class LottoPrize(val matchCount: Int, val amount: Money) {
    FOURTH(3, Money(5_000)),
    THIRD(4, Money(50_000)),
    SECOND(5, Money(1_500_000)),
    FIRST(6, Money(2_000_000_000));

    companion object {
        fun fromMatchCount(matchCount: Int): LottoPrize? {
            return values().find { it.matchCount == matchCount }
        }
    }
}
