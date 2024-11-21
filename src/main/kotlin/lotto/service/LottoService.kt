package lotto.service

import lotto.domain.Lotto
import lotto.domain.LottoTicket
import java.math.BigDecimal
import java.math.RoundingMode

class LottoService(
    private val lotto: Lotto,
) {
    fun lottoIssuance(): List<LottoTicket> {
        return (1..lotto.buyCount()).map { LottoTicket() }
    }

    fun calculateProfitRate(totalPrize: Int): BigDecimal {
        return totalPrize.toBigDecimal()
            .divide(lotto.money.toBigDecimal(), 2, RoundingMode.DOWN)
    }
}
