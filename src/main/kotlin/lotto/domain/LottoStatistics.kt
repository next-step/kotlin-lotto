package lotto.domain

object LottoStatistics {
    private val prizeMap =
        mapOf(
            3 to 5000,
            4 to 50000,
            5 to 1500000,
            6 to 2000000000,
        )

    fun calculate(
        tickets: List<Lotto>,
        winningNumbers: List<Int>,
    ): Map<Int, Int> {
        return tickets.groupBy {
                ticket ->
            ticket.getNumbers().count { it in winningNumbers }
        }.filterKeys { it >= 3 }.mapValues { it.value.size }
    }

    fun calculateTotalPrize(statistics: Map<Int, Int>): Int {
        return statistics.entries.sumOf { (matchCount, count) ->
            prizeMap[matchCount]?.times(count) ?: 0
        }
    }

    fun calculateProfit(
        totalPrize: Int,
        purchaseAmount: Int,
    ): Double {
        return if (purchaseAmount > 0) {
            totalPrize.toDouble() / purchaseAmount
        } else {
            0.0
        }
    }
}
