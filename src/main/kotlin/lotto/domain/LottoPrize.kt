package lotto.domain

import lotto.domain.enums.PrizeType

class LottoPrize(
    private val prize: Map<PrizeType, Int> = mutableMapOf()
) {

    val getPrize get() = prize.toMap()

    fun totalPrizeMoney(): Int = prize
        .map { it.key.money * it.value }
        .sum()
}
