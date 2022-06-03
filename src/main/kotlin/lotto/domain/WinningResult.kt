package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class WinningResult(
    val values: Map<WinningAmount, Int>
) {
    fun calculateYield(): BigDecimal {
        val purchaseAmount = calculatePurchaseAmount()
        val totalWinningAmount = calculateTotalAmount()

        return totalWinningAmount.divide(
            purchaseAmount,
            2,
            RoundingMode.DOWN
        )
    }

    private fun calculateTotalAmount(): BigDecimal {
        return values.asSequence()
            .sumOf { (winningAmount, count) ->
                winningAmount.amount * count.toBigDecimal()
            }
    }

    private fun calculatePurchaseAmount(): BigDecimal {
        return values.asSequence()
            .sumOf { it.value.toBigDecimal() * LottoTicket.PRICE.value }
    }
}
