package lotto

import lotto.domain.LottoShop
import lotto.domain.LottoTicket
import lotto.dto.LottoTicketResponse
import lotto.dto.WinningLottoResponse
import lotto.view.InputView
import lotto.view.ResultView
import lotto.vo.Money

fun main() {
    val buyingRequest = InputView.buying()

    val lottoShop = LottoShop()
    val lottoTickets = lottoShop.buying(Money(buyingRequest.amount))

    ResultView.print(LottoTicketResponse.listOf(lottoTickets))

    val winningLottoRequest = InputView.winningLotto()

    val winningLotto = LottoTicket.of(winningLottoRequest.winningLottoNumbers)
    val lottoRanks = lottoTickets.matching(winningLotto)

    ResultView.print(WinningLottoResponse.of(lottoRanks.count(), lottoRanks.profitRate(lottoTickets.amount())))
}
