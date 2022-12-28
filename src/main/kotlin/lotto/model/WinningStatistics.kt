package lotto.model

data class WinningStatistics(val ranks: List<Rank>) {
    val rate: Double
        get() {
            val quantity = ranks.count().toDouble()
            val total = ranks.toSet().sumOf { rank ->
                ranks.count { it == rank } * rank.reward
            }.toDouble()
            return total / (quantity * TICKET_PRICE)
        }

    val statistics: Map<Rank, Int>
        get() {
            val result = mutableMapOf(
                Rank.FIFTH to 0, Rank.FOURTH to 0, Rank.THIRD to 0,
                Rank.SECOND to 0, Rank.FIRST to 0, Rank.NO_LUCK to 0
            )
            ranks.forEach {
                result[it] = ranks.count { rank -> it == rank }
            }
            return result
        }

    companion object {
        private const val TICKET_PRICE = 1000
    }
}
