package lotto.view

import lotto.domain.LottoTicket

class OutputView {
    fun printTickets(tickets: List<LottoTicket>) {
        tickets.forEach {
            println(it.lottoNumbers.map { lottoNumber -> lottoNumber.number }.joinToString(", ", "[", "]"))
        }
    }
}
