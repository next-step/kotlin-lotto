package lotto

import java.math.BigDecimal
import java.math.RoundingMode

data class Statistics(private val money: Int, private val statistics: Map<Rank, Int>) {
    val profitRate: BigDecimal
        get() = totalProfit().divide(money.toBigDecimal(), 2, RoundingMode.CEILING)

    constructor(money: Int, vararg pairs: Pair<Rank, Int>): this(money, mapOf(*pairs))

    private fun totalProfit(): BigDecimal {
        return statistics.keys.map {
            val prize = it.prize
            val quantity = countOf(it).toBigDecimal()
            prize.multiply(quantity)
        }.reduce(BigDecimal::add)
    }

    fun countOf(rank: Rank): Int {
        return statistics[rank] ?: 0
    }
}
