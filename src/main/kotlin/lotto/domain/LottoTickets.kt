package lotto.domain

data class LottoTickets private constructor(val tickets: List<LottoTicket>) {

    fun matchWith(winningNumbers: WinningNumbers): Result {
        return Result(tickets.map { it.countWith(winningNumbers) })
    }

    companion object {
        fun make(count: Int): LottoTickets = LottoTickets(List(count) { LottoTicket.generateByAuto() })
    }
}
