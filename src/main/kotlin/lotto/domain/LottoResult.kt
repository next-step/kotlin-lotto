package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoResult(
    val statistics: Map<Rank, Int>,
) {
    fun calculateEarningRate(purchasedMoney: PurchasedMoney): Double {
        val totalWinningPrice = statistics.asSequence()
            .map { it.key.winningMoney.multiply(BigDecimal.valueOf(it.value.toLong())) }
            .sumOf { it }
        return totalWinningPrice.divide(BigDecimal.valueOf(purchasedMoney.value.toLong()), 2, RoundingMode.HALF_UP)
            .toDouble()
    }
}
