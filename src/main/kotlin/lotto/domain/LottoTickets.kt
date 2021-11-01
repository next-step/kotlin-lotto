package lotto.domain

data class LottoTickets(val count: Int) {
    val tickets: List<LottoTicket> = List(count) { LottoTicket.generateByAuto() }

    fun matchWith(winningNumbers: List<Int>): Result {
        return Result(tickets.map { it.countWith(winningNumbers) })
    }
}
