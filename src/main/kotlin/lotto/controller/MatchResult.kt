package lotto.controller

class MatchResult(
    val matches: Map<Int, Int>
) {
    companion object {
        val PRIZES = mapOf(
            3 to 5000,
            4 to 50000,
            5 to 1500000,
            6 to 2000000000
        )
    }
    private fun calculateTotalPrice(): Int {
        return matches.entries.sumOf { (matchCount, count) ->
            PRIZES.getOrDefault(matchCount, 0) * count
        }
    }
    fun calculateEarningRate(money: Int): Double {
        val totalPrize = calculateTotalPrice()
        return totalPrize.toDouble() / money
    }
}
