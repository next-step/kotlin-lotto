package lotto.domain

import lotto.domain.enums.PrizeType

class LottoPrize(
    private val prize: Map<Int, Int> = mutableMapOf()
) {

    val getPrize get() = prize.toMap()

    fun totalPrizeMoney(): Int = prize
        .filter { it.value != 0 }
        .map { PrizeType.findPrizeMoney(it.key) }
        .sum()
}
