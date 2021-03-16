package lotto

import lotto.domain.LottoNumber
import lotto.domain.ticket.LottoTicketBundle
import lotto.domain.ticket.LottoTickets
import lotto.domain.ticket.WinningLotto
import lotto.domain.ticket.WinningLottoTicket
import lotto.domain.value.Price
import lotto.domain.vender.LottoTicketVendor
import lotto.domain.vender.TicketVendor
import lotto.view.inputBonusNumber
import lotto.view.inputManualAmount
import lotto.view.inputManualNumbers
import lotto.view.inputPrice
import lotto.view.inputWinningNumbers
import lotto.view.showLottoTickets
import lotto.view.showResultStatic

object Lotto {
    fun start() {
        val price = inputPrice()
        val manualAmount = inputManualAmount()
        val manualNumberRequest = inputManualNumbers(manualAmount)

        val manualLottoTickets = manualNumberRequest.toTickets()
        val autoPrice = price - Price(manualAmount.times(TicketVendor.TICKET_PRICE))

        val lottoTicketBundle = LottoTicketBundle()
        lottoTicketBundle.addManualLottoTickets(manualLottoTickets)

        val ticketVendor = LottoTicketVendor()
        val automaticTicketCollection = ticketVendor.buyAutomaticTicket(autoPrice)
        val automaticTickets = LottoTickets(automaticTicketCollection)
        lottoTicketBundle.addAutomaticLottoTickets(automaticTickets)
        showLottoTickets(lottoTicketBundle)

        val winningTicket = WinningLottoTicket(inputWinningNumbers().toNumbers())
        val bonusNumber = LottoNumber.of(inputBonusNumber())
        val lottoResult = lottoTicketBundle.compare(WinningLotto(winningTicket, bonusNumber))

        showResultStatic(lottoResult, price)
    }
}
