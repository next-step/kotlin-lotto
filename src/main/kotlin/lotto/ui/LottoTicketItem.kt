package lotto.ui

import lotto.LottoTicket

class LottoTicketItem(private val ticket: LottoTicket) : UI {
    override fun draw() {
        val lottoNumbers = ticket.lottoNumber.numbers
        println("[${lottoNumbers.joinToString(", ") { it.toString() }}]")
    }
}
