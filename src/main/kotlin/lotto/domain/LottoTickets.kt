package lotto.domain

data class LottoTickets private constructor(val tickets: List<LottoTicket>) {

    fun matchWith(winningNumbers: List<Int>, bonusNumber: Int): Result {
        return Result(tickets.map { it.countWith(winningNumbers, bonusNumber) })
    }

    companion object {
        fun make(count: Int): LottoTickets = LottoTickets(List(count) { LottoTicket.generateByAuto() })
    }
}
