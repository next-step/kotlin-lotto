package lotto.domain

class LottoTickets(val tickets: List<LottoTicket>) {
    fun aggregateByRank(winningLottoInfo: WinningLottoInfo): LottoResult =
        winningLottoInfo.aggregateByRank(tickets)

    fun size(): Int = tickets.size

    companion object {
        fun of(tickets: List<List<Int>>): LottoTickets =
            LottoTickets(tickets.map { LottoTicket.of(it) })
    }
}
