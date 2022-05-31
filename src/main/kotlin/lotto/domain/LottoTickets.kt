package lotto.domain

/**
 * LottoTicket을 저장하는 일급 컬렉션
 * Created by Jaesungchi on 2022.05.31..
 */
class LottoTickets(val tickets: List<LottoTicket>) {
    fun getSize() = tickets.size
}
