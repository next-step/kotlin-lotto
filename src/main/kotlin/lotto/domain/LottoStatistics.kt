package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

object LottoStatistics {
    fun calculateRatio(purchaseCount: Int): BigDecimal {
        return PrizeResult.winningPrize().toBigDecimal()
            .divide((purchaseCount * LottoTicket.PRICE).toBigDecimal(), 2, RoundingMode.HALF_EVEN)
    }
}
