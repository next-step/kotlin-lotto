package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

object LottoCalculator {
    fun calculateLottoCount(
        totalPurchaseAmount: BigDecimal,
        pricePerAmount: BigDecimal
    ): Int {
        require(pricePerAmount > BigDecimal.ZERO) { "invalid pricePerAmount : $pricePerAmount" }
        require(totalPurchaseAmount > pricePerAmount) { "1 Lotto costs $pricePerAmount. Please enter amount larger than $pricePerAmount." }
        return totalPurchaseAmount.divide(pricePerAmount).toInt()
    }

    fun calculateProfitRate(
        totalProfit: BigDecimal,
        totalPurchaseAmount: BigDecimal
    ): BigDecimal {
        require(totalPurchaseAmount > BigDecimal.ZERO) { "invalid totalPurchaseAmount : $totalPurchaseAmount" }
        if (totalProfit == BigDecimal.ZERO) return BigDecimal.ZERO
        return totalProfit.divide(totalPurchaseAmount, 2, RoundingMode.HALF_UP)
    }
}
