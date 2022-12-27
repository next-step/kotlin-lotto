package lotto.domain

object LottoStatistics {
    fun calculate(ticketBundle: List<LottoTicket>, winningNumber: Set<LottoNumber>): Map<Int, Int> {
        return ticketBundle
            .map {
                it.numbers.intersect(winningNumber).size
            }
            .groupingBy { it }
            .eachCount()
    }
}
