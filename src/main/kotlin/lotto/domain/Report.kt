package lotto.domain

import kotlin.math.roundToInt

data class Report(
    private val ranks: Ranks = Ranks()
) {
    val fifthCount: Int
        get() = ranks.rankCount(Rank.FIFTH)
    val fourthCount: Int
        get() = ranks.rankCount(Rank.FOURTH)

    val thirdCount: Int
        get() = ranks.rankCount(Rank.THIRD)

    val secondCount: Int
        get() = ranks.rankCount(Rank.SECOND)
    val firstCount: Int
        get() = ranks.rankCount(Rank.FIRST)

    fun getRateOfReturn(): Double {
        if (ranks.size == 0) return 0.0
        return (ranks.totalPrize() / lottosKRW * 100.0).roundToInt() / 100.0
    }

    private val lottosKRW: Int
        get() = ranks.size * 1000
}
