package lotto.model.prize

enum class Prize(val matchingCount: Int, val prizeMoney: Money, private val needBonusMatch: Boolean? = null) {
    ONE(6, Money(2_000_000_000)),
    TWO_BONUS(5, Money(30_000_000), true),
    TWO(5, Money(1_500_000), false),
    THREE(4, Money(50_000)),
    FOUR(3, Money(5_000)),
    ZERO(0, Money(0));

    fun calculateMoney(prizeCount: Int) = prizeMoney * prizeCount

    fun isPrize(matchingCount: Int, isBonusMatch: Boolean) =
        if (isTwo(matchingCount)) {
            isBonusMatch == this.needBonusMatch
        } else {
            matchingCount == this.matchingCount
        }

    private fun isTwo(matchingCount: Int) = matchingCount == TWO.matchingCount

    companion object {
        fun getPrize(matchingCount: Int, isBonusMatch: Boolean = false) =
            values().find { it.isPrize(matchingCount, isBonusMatch) } ?: ZERO
    }
}
