package lotto.domain.selling

import java.math.BigDecimal
import java.math.RoundingMode

data class ExchangeResult(val paymentResult: PaymentResult, val details: Map<Prize, Int>) {
    private val totalPrizeMoney = details.keys.sumBy { Prize(it.matchCount).prizeMoney }

    val rateOfReturn: BigDecimal =
        BigDecimal(totalPrizeMoney).divide(BigDecimal(paymentResult.money), EXCHANGE_SCALE, RoundingMode.DOWN)

    companion object {
        private const val EXCHANGE_SCALE = 2
    }
}
