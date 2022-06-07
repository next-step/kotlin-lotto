package lotto.domain

import java.math.BigDecimal

class LottoStatistics(private val money: Money, results: Map<Winning, Int>) {
    var totalAmount: BigDecimal = 0.toBigDecimal()

    init {
        results.forEach { (winning, winningCount) ->
            totalAmount += (winning.winningAmount * winningCount).toBigDecimal()
        }
    }

    fun getYield(): BigDecimal = totalAmount / money.price.toBigDecimal()
}
