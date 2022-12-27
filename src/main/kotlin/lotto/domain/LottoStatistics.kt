package lotto.domain

object LottoStatistics {
    fun calculate(ticketBundle: List<LottoTicket>, winningNumber: Set<Int>): Map<Int, Int> {
        return ticketBundle
            .map { ticket ->
                ticket.numbers
                    .map { it.number }
                    .intersect(winningNumber)
                    .size
            }
            .groupingBy { it }
            .eachCount()
    }
}
