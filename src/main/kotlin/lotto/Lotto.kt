package lotto

import lotto.domain.ticket.LottoTickets
import lotto.domain.vender.LottoTicketVendor
import lotto.view.lottoRequest
import lotto.view.showLottoTickets
import lotto.view.showResultStatic
import lotto.view.winningLottoRequest

object Lotto {
    fun start() {
        val purchaseRequest = lottoRequest()
        val lottoTicketCreateDto = purchaseRequest.toLottoTicketCreateDto()

        val vendor = LottoTicketVendor(lottoTicketCreateDto)
        val tickets = LottoTickets(vendor.buyTickets())
        showLottoTickets(tickets)

        val winningRequest = winningLottoRequest()
        val winningLottoCreator = winningRequest.toWinningLottoCreator()

        val winningLotto = winningLottoCreator.toWinningLotto()
        val lottoResult = tickets.compare(winningLotto)

        showResultStatic(lottoResult, purchaseRequest.price)
    }
}
