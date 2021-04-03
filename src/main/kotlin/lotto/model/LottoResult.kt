package lotto.model

import lotto.model.winning.WinningCounter
import java.math.BigDecimal
import java.math.RoundingMode

data class LottoResult(val winningCounter: WinningCounter, private val ticketPriceSum: Money) {
    val benefitRate: Double
        get() {
            return BigDecimal(winningCounter.priceSum / ticketPriceSum)
                .setScale(SCALE, RoundingMode.DOWN)
                .toDouble()
        }

    companion object {
        private const val SCALE = 2
    }
}
