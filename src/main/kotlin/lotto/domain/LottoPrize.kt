package lotto.domain

enum class LottoPrize(val matchCount: Int, val amount: Money) {
    FIFTH(3, Money(5_000)),
    FOURTH(4, Money(50_000)),
    THIRD(5, Money(1_500_000)),
    SECOND(5, Money(30_000_000)),
    FIRST(6, Money(2_000_000_000));

    companion object {
        fun fromMatchCount(matchCount: Int, bonusMatch: Boolean = false): LottoPrize? {
            if (matchCount == 5) {
                return if (bonusMatch) SECOND else THIRD
            }
            return values().find { it.matchCount == matchCount }
        }
    }
}
