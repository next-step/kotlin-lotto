package domain

object Settlement {

    fun calculateProfitRate(
        prizeCountMap: Map<Int, Int>,
        investment: Int,
    ): Double {
        val totalPrizeMoney = prizeCountMap.entries.sumOf { (prizeMoney, count) -> count * prizeMoney }
        return totalPrizeMoney.toDouble() / investment
    }
}
