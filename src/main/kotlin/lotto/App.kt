package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoShop
import lotto.domain.LottoTicket
import lotto.dto.LottoTicketResponse
import lotto.dto.WinningLottoRequest
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

    val winningLotto = winningLotto(winningLottoRequest)
    val lottoRanks = lottoTickets.matching(winningLotto)

    ResultView.print(WinningLottoResponse.of(lottoRanks.count(), lottoRanks.profitRate()))
}

private fun winningLotto(winningLottoRequest: WinningLottoRequest): LottoTicket {
    val lottoNumbers = winningLottoRequest.winningLottoNumbers
        .split(", ")
        .map { LottoNumber(it.toInt()) }
    return LottoTicket(lottoNumbers)
}
