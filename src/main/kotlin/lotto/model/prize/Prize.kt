package lotto.model.prize

enum class Prize(val matchingCount: Int, val prizeMoney: Money, private val needBonusMatch: Boolean) {
    ONE(6, Money(2_000_000_000), false),
    TWO_BONUS(5, Money(30_000_000), true),
    TWO(5, Money(1_500_000), false),
    THREE(4, Money(50_000), false),
    FOUR(3, Money(5_000), false),
    ZERO(0, Money(0), false);

    fun isPrize(matchingCount: Int, isBonusMatch: Boolean) =
        matchingCount == this.matchingCount && isBonusMatch(isBonusMatch)

    private fun isBonusMatch(isBonusMatch: Boolean) = if (this.needBonusMatch) {
        isBonusMatch == this.needBonusMatch
    } else {
        true
    }

    companion object {
        fun getPrize(matchingCount: Int, isBonusMatch: Boolean = false) =
            values().find { it.isPrize(matchingCount, isBonusMatch) } ?: ZERO
    }
}
