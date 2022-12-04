package lotto

import kotlin.math.floor

class Statistics(val statistic: MutableMap<Int, Int?> = mutableMapOf()) {
    init {
        for (i in 1..6) {
            statistic[i] = 0
        }
    }

    fun add(result: Int) {
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

        result += this.statistic[Rank.FOUR.rank]!!.times(Rank.FOUR.price)
        result += this.statistic[Rank.THIRD.rank]!!.times(Rank.THIRD.price)
        result += this.statistic[Rank.SECOND.rank]!!.times(Rank.SECOND.price)
        result += this.statistic[Rank.FIRST.rank]!!.times(Rank.FIRST.price)
        return result
    }
}
