package lotto.domain

object EarningsRateCalculator {

    fun run(result: Map<Rank, Int>, purchase: Int): Float {
        val totalPrize = result.map { (rank, count) ->
            rank.prize * count
        }.sum()
        return totalPrize / purchase.toFloat()
    }

    fun isLoss(rate: Float): Boolean = rate < 1
}
