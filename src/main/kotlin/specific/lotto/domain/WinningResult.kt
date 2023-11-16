package specific.lotto.domain

import java.util.SortedMap
import java.util.TreeMap

data class WinningResult(val tickets: List<Ticket>, val winningNumbers: WinningNumber) {

    val aggregatedData: SortedMap<Rank, Int> = aggregate()

    val totalPrize: Long = calculateTotalPrize()

    private fun aggregate(): SortedMap<Rank, Int> {
        val aggregatedData = TreeMap<Rank, Int>().apply {
            compareBy<Rank> { it.countOfSameNumber }
            putAll(Rank.values().map { it to 0 })
        }
        tickets
            .map { countSameNumber(it, winningNumbers) }
            .mapNotNull { Rank.getRank(it) }
            .groupBy { it }
            .mapValues { (_, tickets) -> tickets.size }
            .forEach { (rank, count) -> aggregatedData[rank] = count }
        return aggregatedData
    }

    private fun calculateTotalPrize() =
        aggregatedData.entries.fold(0L) { sum, (rank, count) -> sum + rank.prize * count }

    enum class Rank(val prize: Long, val countOfSameNumber: Int) {
        FIRST(2000000000L, 6),
        SECOND(1500000L, 5),
        THIRD(50000L, 4),
        FOURTH(5000L, 3);

        companion object {
            fun getRank(countOfSameNumber: Int): Rank? =
                values().firstOrNull { it.countOfSameNumber == countOfSameNumber }
        }
    }

    companion object {
        fun countSameNumber(ticket: Ticket, winningNumber: WinningNumber) =
            ticket.numberCombination.numbers.intersect(winningNumber.numberCombination.numbers).size
    }
}
