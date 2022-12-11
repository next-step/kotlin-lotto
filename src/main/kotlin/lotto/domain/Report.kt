package lotto.domain

import kotlin.math.roundToInt

data class Report(
    val missCount: Int = 0,
    val fourthCount: Int = 0,
    val thirdCount: Int = 0,
    val secondCount: Int = 0,
    val firstCount: Int = 0
) {

    fun getRateOfReturn(): Double {
        return (calculatePrize() / calculateLottoBundlePrice() * 100.0).roundToInt() / 100.0
    }

    private fun calculatePrize(): Int {
        return Rank.FOURTH.calculatePrize(fourthCount) + Rank.THIRD.calculatePrize(thirdCount) +
            Rank.SECOND.calculatePrize(secondCount) + Rank.FIRST.calculatePrize(firstCount)
    }

    private fun calculateLottoBundlePrice(): Int {
        return (firstCount + secondCount + thirdCount + fourthCount + missCount) * Lotto.krw.money
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Report) return false

        if (missCount != other.missCount) return false
        if (fourthCount != other.fourthCount) return false
        if (thirdCount != other.thirdCount) return false
        if (secondCount != other.secondCount) return false
        if (firstCount != other.firstCount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = missCount
        result = 31 * result + fourthCount
        result = 31 * result + thirdCount
        result = 31 * result + secondCount
        result = 31 * result + firstCount
        return result
    }
}
