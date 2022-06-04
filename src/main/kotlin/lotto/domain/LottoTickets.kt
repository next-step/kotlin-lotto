package lotto.domain

/**
 * LottoTicket을 저장하는 일급 컬렉션
 * Created by Jaesungchi on 2022.05.31..
 */
class LottoTickets(val tickets: List<LottoTicket>) {
    fun getSize() = tickets.size

    operator fun plus(tickets: LottoTickets): LottoTickets {
        return LottoTickets(this.tickets + tickets.tickets)
    }

    companion object {
        fun of(lists: List<String>): LottoTickets {
            return LottoTickets(lists.map { LottoTicket.of(it) })
        }
    }
}
