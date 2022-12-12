package lotto.domain

import java.math.BigDecimal
import java.math.RoundingMode

class LottoResult(private val ranks: List<LottoRank>) {
    fun countByRank(): Map<LottoRank, Int> {
        val initialMap = enumValues<LottoRank>().associateWith { 0 }

        return initialMap + ranks.groupingBy { it }
            .eachCount()
    }

    fun profit(payment: Payment): BigDecimal {
        val winning = ranks.sumOf { it.winning }

        return BigDecimal.valueOf(winning).divide(BigDecimal.valueOf(payment.toDouble()), 2, RoundingMode.DOWN)
    }
}
