package lotto

import lotto.domain.ticket.LottoTickets
import lotto.domain.ticket.WinningLottoTicket
import lotto.domain.vender.LottoTicketVendor
import lotto.view.inputPrice
import lotto.view.inputWinningNumbers
import lotto.view.showLottoTickets
import lotto.view.showResultStatic

class Lotto {
    fun start() {
        val price = inputPrice()
        val ticketVendor = LottoTicketVendor()
        val buyTickets = ticketVendor.buyAutomaticTicket(price)
        val tickets = LottoTickets(buyTickets)
        showLottoTickets(tickets.tickets)

        val winningTicket = WinningLottoTicket(inputWinningNumbers().toNumbers())
        val lottoResult = tickets.compare(winningTicket)

        showResultStatic(lottoResult, price)
    }
}
