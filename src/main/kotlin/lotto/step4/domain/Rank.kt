package lotto.step4.domain

enum class Rank(val matchCount: Int, val hasBonusNumber: Boolean, val winningAmount: Money) {
    FIRST(6, false, Money(2_000_000_000)),
    SECOND(5, true, Money(30_000_000)),
    THIRD(5, false, Money(1_500_000)),
    FOURTH(4, false, Money(50_000)),
    FIFTH(3, false, Money(5_000)),
    MISS(0, false, Money(0)),
    ;

    companion object {
        fun valueOf(
            matchCount: Int,
            hasBonusNumber: Boolean,
        ): Rank {
            return entries.find { it.matchCount == matchCount && it.hasBonusNumber == hasBonusNumber } ?: MISS
        }
    }
}
