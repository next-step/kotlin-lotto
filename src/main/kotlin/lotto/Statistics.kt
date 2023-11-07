package lotto

import java.math.BigDecimal
import java.math.RoundingMode

data class Statistics(private val money: Int, private val statistics: Map<Int, Int>) {
    val profitRate: BigDecimal
        get() = totalProfit().divide(money.toBigDecimal(), 2, RoundingMode.CEILING)

    constructor(money: Int, vararg pairs: Pair<Int, Int>): this(money, mapOf(*pairs))

    private fun totalProfit(): BigDecimal {
        return statistics.keys.map {
            val prize = PRIZES[it] ?: BigDecimal.ZERO
            val quantity = countOf(it).toBigDecimal()
            prize.multiply(quantity)
        }.reduce(BigDecimal::add)
    }

    fun countOf(rank: Int): Int {
        return statistics[rank] ?: 0
    }

    companion object {
        private val PRIZES = mapOf(
            3 to "5000".toBigDecimal(),
            4 to "50000".toBigDecimal(),
            5 to "1500000".toBigDecimal(),
            6 to "2000000000".toBigDecimal(),
        )
    }
}
