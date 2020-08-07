package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

object LottoStatistics {
    fun calculateRatio(purchaseCount: Int): BigDecimal {
        return PrizeGenerator.winningPrize().toBigDecimal()
            .divide((purchaseCount * LOTTO_PRICE).toBigDecimal(), 2, RoundingMode.HALF_EVEN)
    }
}
