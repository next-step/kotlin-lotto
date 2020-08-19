package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoStatistics(val result: Map<PrizeResult, Int>) {

    constructor(prizeList: List<PrizeResult>) : this(prizeList.groupingBy { it }.eachCount())

    fun calculateRatio(purchaseCount: Int): BigDecimal {

        val totalPrize = result.map { it.key.prize * it.value }.sum()

        return totalPrize.toBigDecimal()
            .divide((purchaseCount * LottoTicket.PRICE).toBigDecimal(), 2, RoundingMode.HALF_EVEN)
    }
}
