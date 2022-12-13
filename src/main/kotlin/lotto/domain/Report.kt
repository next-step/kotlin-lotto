package lotto.domain

import kotlin.math.roundToInt

data class Report(
    private val ranks: Ranks = Ranks()
) {
    val fifthCount: Int
        get() = ranks.fifthCount
    val fourthCount: Int
        get() = ranks.fourthCount

    val thirdCount: Int
        get() = ranks.thirdCount

    val secondCount: Int
        get() = ranks.secondCount
    val firstCount: Int
        get() = ranks.firstCount

    fun getRateOfReturn(): Double {
        if (ranks.size == 0) return 0.0
        return (ranks.totalPrize / lottosKRW * 100.0).roundToInt() / 100.0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Report) return false

        if (ranks != other.ranks) return false

        return true
    }

    override fun hashCode(): Int {
        return ranks.hashCode()
    }

    private val lottosKRW: Int
        get() = ranks.size * 1000
}
