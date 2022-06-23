package lotto.domain

import lotto.domain.lottoticket.LottoTicket
import java.math.BigDecimal
import java.math.RoundingMode

class WinningResult(
    val amountWithWinnings: Map<WinningAmount, Int>
) {
    fun calculateYield(): BigDecimal {
        val totalWinningAmount = calculateTotalAmount()
        val purchaseAmount = calculatePurchaseAmount()

        return totalWinningAmount.divide(
            purchaseAmount,
            2,
            RoundingMode.DOWN
        )
    }

    private fun calculateTotalAmount(): BigDecimal {
        return amountWithWinnings.entries
            .sumOf { (winningAmount, count) ->
                winningAmount.amount * count.toBigDecimal()
            }
    }

    private fun calculatePurchaseAmount(): BigDecimal {
        return amountWithWinnings.entries
            .sumOf { it.value.toBigDecimal() * LottoTicket.PRICE.value }
    }
}
