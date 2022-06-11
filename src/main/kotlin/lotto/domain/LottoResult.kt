package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoResult(
    val statistics: Map<Rank, Int>,
) {
    fun calculateEarningRate(purchasedMoney: PurchasedMoney): Double {
        val totalWinningPrice = statistics.asSequence()
            .sumOf {
                it.key.winningMoney.multiply(BigDecimal(it.value))
            }

        return totalWinningPrice.divide(BigDecimal(purchasedMoney.value), 2, RoundingMode.HALF_UP)
            .toDouble()
    }
}
