package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoResult(
    val statistics: Map<Rank, Int>,
) {
    fun calculateEarningRate(money: Money): Double {
        val totalWinningPrice = statistics.asSequence()
            .sumOf {
                it.key.winningMoney.multiply(BigDecimal(it.value))
            }

        return totalWinningPrice.divide(BigDecimal(money.value), 2, RoundingMode.HALF_UP)
            .toDouble()
    }
}
