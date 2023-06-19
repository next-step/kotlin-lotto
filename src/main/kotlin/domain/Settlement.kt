package domain

object Settlement {

    fun calculateProfitRate(
        prizeCountMap: Map<Prize, Int>,
        sunkCost: Int,
    ): Double {
        val profit = prizeCountMap.entries.sumOf { (key, value) ->
            value * key.prizeMoney
        }
        return profit.toDouble() / sunkCost
    }
}
