package lotto.domain

import java.math.BigDecimal

class LottoStatistics(private val money: Money, private val results: LottoResult) {

    fun getTotalAmount(): BigDecimal = results.getTotalAmount()

    fun getYield(): BigDecimal = getTotalAmount() / money.price.toBigDecimal()
}
