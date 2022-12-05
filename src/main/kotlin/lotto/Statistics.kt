package lotto

import kotlin.math.floor

class Statistics(val statistic: MutableMap<Rank, Int?> = mutableMapOf()) {
    init {
        for (value in Rank.values()) {
            statistic[value] = 0
        }
    }

    fun add(result: Rank) {
        val i = statistic[result]?.plus(1)
        if (i != null) {
            statistic[result] = i
        }
        if (i == null) {
            statistic[result] = 1
        }
    }

    fun statistic(allPrice: Int): Double {
        val result = sum() / allPrice
        return floor(result * 100) /100
    }

    private fun sum(): Double {
        var result = 0.0

        result += this.statistic[Rank.FIVE]!!.times(Rank.FIVE.price)
        result += this.statistic[Rank.FOUR]!!.times(Rank.FOUR.price)
        result += this.statistic[Rank.THIRD]!!.times(Rank.THIRD.price)
        result += this.statistic[Rank.SECOND]!!.times(Rank.SECOND.price)
        result += this.statistic[Rank.FIRST]!!.times(Rank.FIRST.price)
        return result
    }
}
