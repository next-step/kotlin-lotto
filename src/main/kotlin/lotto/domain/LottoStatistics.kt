package lotto.domain

import java.math.BigDecimal

class LottoStatistics(private val results: LottoResult) {

    fun getTotalAmount(): BigDecimal = results.getTotalAmount()

    fun getYield(): BigDecimal = getTotalAmount() / (results.getTotalCount() * LottoMachine.TICKET_PRICE).toBigDecimal()
}
