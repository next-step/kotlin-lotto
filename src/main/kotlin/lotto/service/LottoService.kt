package lotto.service

import lotto.domain.LottoPurchasingMachine
import lotto.domain.LottoTicket
import java.math.BigDecimal
import java.math.RoundingMode

class LottoService(
    private val lottoPurchasingMachine: LottoPurchasingMachine,
) {
    fun lottoIssuance(): List<LottoTicket> {
        return (1..lottoPurchasingMachine.buyCount()).map { LottoTicket() }
    }

    fun calculateProfitRate(totalPrize: Int): BigDecimal {
        return totalPrize.toBigDecimal()
            .divide(lottoPurchasingMachine.money.toBigDecimal(), 2, RoundingMode.DOWN)
    }
}
