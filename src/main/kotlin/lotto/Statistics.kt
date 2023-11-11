package lotto

import java.math.BigDecimal
import java.math.RoundingMode

data class Statistics(private val money: Int, private val statistics: Map<Rank, Int>) {
    val profitRate: BigDecimal
        get() = totalProfit().divide(money.toBigDecimal(), 2, RoundingMode.CEILING)

    constructor(money: Int, vararg pairs: Pair<Rank, Int>): this(money, mapOf(*pairs))

    private fun totalProfit(): BigDecimal {
        return statistics.keys.map {
            val prize = PRIZES[it] ?: BigDecimal.ZERO
            val quantity = countOf(it).toBigDecimal()
            prize.multiply(quantity)
        }.reduce(BigDecimal::add)
    }

    fun countOf(rank: Rank): Int {
        return statistics[rank] ?: 0
    }

    companion object {
        private val PRIZES = mapOf(
            Rank.FIFTH to "5000".toBigDecimal(),
            Rank.FOURTH to "50000".toBigDecimal(),
            Rank.THIRD to "1500000".toBigDecimal(),
            Rank.SECOND to "30000000".toBigDecimal(),
            Rank.FIRST to "2000000000".toBigDecimal(),
        )
    }
}
