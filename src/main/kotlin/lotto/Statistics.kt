package lotto

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
        return allPrice / sum()
    }

    private fun sum(): Double {
        var result = 0.0

        result += this.statistic[3]!!.times(5_000)
        result += this.statistic[4]!!.times(50_000)
        result += this.statistic[5]!!.times(1_500_000)
        result += this.statistic[6]!!.times(2_000_000_000)
        return result
    }
}
