package lotto.domain

import lotto.domain.enums.PrizeType

class LottoPrize(
    private val prizeMap: Map<Int, Int> = mutableMapOf()
) {

    fun totalPrizeMoney(): Int = prizeMap
        .filter { it.value != 0 }
        .map { PrizeType.findPrizeMoney(it.key) }
        .sum()

    fun allPrize(): Map<Int, Int> = prizeMap.toMap()
}
