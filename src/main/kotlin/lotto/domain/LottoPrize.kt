package lotto.domain

enum class LottoPrize(
    val count: Int,
    val reward: Money,
    private val mustMatchingBonusNumber: Boolean = false
) {

    FIRST_PRIZE(6, Money(2_000_000_000)),
    SECOND_PRIZE(5, Money(30_000_000), true),
    THIRD_PRIZE(5, Money(1_500_000)),
    FOURTH_PRIZE(4, Money(50_000)),
    FIFTH_PRIZE(3, Money(5_000)),
    WHACK(0, Money.EMPTY);

    private fun matchPrize(matchedCount: Int, hasBonusNumber: Boolean): Boolean {
        return count == matchedCount && checkBonusNumber(hasBonusNumber)
    }

    private fun checkBonusNumber(hasBonusNumber: Boolean): Boolean {
        if (mustMatchingBonusNumber) {
            return hasBonusNumber
        }
        return true
    }

    companion object {
        fun valueOf(matchedCount: Int, hasBonusNumber: Boolean): LottoPrize {
            return values().firstOrNull { it.matchPrize(matchedCount, hasBonusNumber) } ?: WHACK
        }
    }
}
