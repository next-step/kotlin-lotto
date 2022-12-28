package lotto.domain

object LottoComparator {
    fun compare(ticketBundle: List<LottoTicket>, winningNumber: Set<Int>): LottoStatistics {
        val rank = ticketBundle
            .map {
                it.numbers.intersect(winningNumber).size
            }
            .groupingBy { WinningAmount.from(it) }
            .eachCount()

        return LottoStatistics(rank)
    }
}
