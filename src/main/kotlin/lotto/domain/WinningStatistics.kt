package lotto.domain

class WinningStatistics(tickets: LottoTickets, private val winningLotto: WinningLotto) {
    private val statistics: Map<WinningCategory, Int> =
        tickets.getTickets()
            .groupBy { winningLotto.determineCategory(it) }
            .mapValues { it.value.size }

    fun getStatistics(): Map<WinningCategory, Int> = statistics

    fun calculateTotalPrize(): Int {
        return statistics.entries.sumOf { (category, count) ->
            category.prize * count
        }
    }

    fun calculateProfitRate(purchaseAmount: Int): Double {
        val totalPrize = calculateTotalPrize()
        return if (purchaseAmount > 0) totalPrize.toDouble() / purchaseAmount else 0.0
    }
}
