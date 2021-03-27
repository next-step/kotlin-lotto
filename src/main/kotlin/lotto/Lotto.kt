package lotto

import lotto.domain.LottoNumber
import lotto.domain.ticket.LottoTickets
import lotto.domain.ticket.WinningLotto
import lotto.domain.ticket.WinningLottoTicket
import lotto.domain.vender.LottoTicketVendor
import lotto.view.inputBonusNumber
import lotto.view.inputWinningNumbers
import lotto.view.lottoRequest
import lotto.view.showLottoTickets
import lotto.view.showResultStatic

object Lotto {
    fun start() {
        val purchaseRequest = lottoRequest()
        val createDto = purchaseRequest.toCreateDto()

        val vendor = LottoTicketVendor(createDto)
        val tickets = LottoTickets(vendor.buyTickets())
        showLottoTickets(tickets)

        val winningTicket = WinningLottoTicket(inputWinningNumbers().toNumbers())
        val bonusNumber = LottoNumber.of(inputBonusNumber())
        val lottoResult = tickets.compare(WinningLotto(winningTicket, bonusNumber))

        showResultStatic(lottoResult, purchaseRequest.price)
    }
}
