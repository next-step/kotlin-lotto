package lotto

import java.math.RoundingMode

class WinningBoard(private val winningResults: List<WinningResult>) {
    fun getWinningCount(winningResult: WinningResult): Int = winningResults.count { it == winningResult }

    fun calculateRateOfReturn(totalCost: Int): Double {
        require(totalCost >= TICKET_PRICE) {
            "총 구매 비용은 최소 로또 티켓 1매 가격이어야 합니다"
        }

        val totalWinningAmount = winningResults.sumOf { it.winnings }
        val returns = totalWinningAmount.toDouble() / totalCost
        return roundReturns(returns)
    }

    private fun roundReturns(returns: Double) = returns.toBigDecimal().setScale(2, RoundingMode.DOWN).toDouble()

    companion object {
        private const val TICKET_PRICE = 1000
    }
}
