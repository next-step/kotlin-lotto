package lotto.domain

data class WinningResult(
    private val winnings: List<WinningPlace>,
    private val cost: Money
) {
    private val totalReword = winnings.fold(0) { reword, winning ->
        reword + winning.reward
    }
    val rateOfReturn = totalReword / cost.toDouble()

    private fun Money.toDouble(): Double = amount.toDouble()

    private val groupByWinningPlace = winnings.groupBy({ it }, { it.reward })

    operator fun get(winningPlace: WinningPlace): Int {
        return groupByWinningPlace[winningPlace]?.size ?: 0
    }
}
