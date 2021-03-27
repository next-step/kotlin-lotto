package lotto.domain.ticket

import lotto.domain.result.LottoResult

class LottoTickets(
    val tickets: List<LottoTicket>
) {
    fun compare(winningLotto: WinningLotto): LottoResult {
        val winningBoards = tickets.map {
            winningLotto.compare(it)
        }
        return LottoResult(winningBoards)
    }

    fun merge(lottoTickets: LottoTickets): LottoTickets {
        val tickets = this.tickets.toMutableList()
        tickets.addAll(lottoTickets.tickets)
        return LottoTickets(tickets)
    }

    fun size(): Int {
        return tickets.size
    }

    fun automaticSize(): Int {
        return tickets.filterIsInstance<LottoTicket.AutomaticLottoTicket>()
            .size
    }

    fun manualSize(): Int {
        return tickets.filterIsInstance<LottoTicket.ManualLottoTicket>()
            .size
    }

    companion object {
        fun empty(): LottoTickets {
            return LottoTickets(emptyList())
        }
    }
}
