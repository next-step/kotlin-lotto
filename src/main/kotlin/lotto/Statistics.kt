package lotto

object Statistics {
    fun getWinningResult(results: List<Winning>): Map<Winning, Int> {
        return Winning.values()
            .filter { it != Winning.FAIL }
            .associateWith { winning -> results.count { it == winning } }
            .toSortedMap { w1, w2 -> w1.winningAmount - w2.winningAmount }
    }

    fun getYield(result: Map<Winning, Int>, cost: Price): Double {
        var totalRevenue = 0
        result.forEach { (winning, count) ->
            totalRevenue += winning.winningAmount * count
        }
        return totalRevenue / cost.amount.toDouble()
    }
}
