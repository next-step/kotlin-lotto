package lotto

import java.math.BigDecimal

data class Statistics(private val money: Int, private val statistics: Map<Int, Int>) {
    val profitRate: BigDecimal
        get() = totalProfit().divide(BigDecimal(money))

    constructor(money: Int, vararg pairs: Pair<Int, Int>): this(money, mapOf(*pairs))

    private fun totalProfit(): BigDecimal {
        return statistics.keys.map {
            val prize = PRIZES[it] ?: BigDecimal.ZERO
            val quantity = statistics[it] ?: 0
            prize.multiply(BigDecimal(quantity))
        }.reduce(BigDecimal::add)
    }

    companion object {
        private val PRIZES = mapOf(
            3 to BigDecimal("5000"),
            4 to BigDecimal("50000"),
            5 to BigDecimal("1500000")
        )
    }
}
