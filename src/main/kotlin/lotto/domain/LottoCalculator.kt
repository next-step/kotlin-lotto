package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoCalculator {
    fun calculateLottoCount(
        totalPurchaseAmount: BigDecimal,
        pricePerAmount: BigDecimal
    ): Int {
        require(pricePerAmount > BigDecimal.ZERO) { "invalid pricePerAmount : $pricePerAmount" }
        return totalPurchaseAmount.divide(pricePerAmount).toInt()
    }

    fun calculateProfitRate(
        totalProfit: BigDecimal,
        totalPurchaseAmount: BigDecimal
    ): BigDecimal {
        if (totalProfit == BigDecimal.ZERO) return BigDecimal.ZERO
        return totalProfit.divide(totalPurchaseAmount).setScale(2, RoundingMode.UP)
    }
}
