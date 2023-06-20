package domain

object Settlement {

    fun calculateProfitRate(
        prizeCountMap: Map<Prize, Int>,
        investment: Int,
    ): Double {
        val totalPrizeMoney = prizeCountMap.entries.sumOf { (prize, count) ->
            count * prize.prizeMoney
        }
        return totalPrizeMoney.toDouble() / investment
    }
}
