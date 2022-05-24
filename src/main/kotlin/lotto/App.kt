package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoShop
import lotto.domain.LottoTicket
import lotto.domain.WinningLotto
import lotto.dto.LottoTicketResponse
import lotto.dto.WinningLottoResponse
import lotto.view.InputView
import lotto.view.ResultView
import lotto.vo.Money

fun main() {
    val buyingRequest = InputView.buying()

    val lottoShop = LottoShop()
    val lottoTickets = lottoShop.buying(Money(buyingRequest.amount))

    ResultView.printLottoTickets(LottoTicketResponse.listOf(lottoTickets))

    val winningLottoRequest = InputView.winningLotto()

    val winningLotto = WinningLotto(
        LottoTicket.of(winningLottoRequest.winningLottoNumbers),
        LottoNumber.of(winningLottoRequest.bonusNumber)
    )
    val lottoRanks = lottoTickets.matching(winningLotto)

    ResultView.printRank(WinningLottoResponse.of(lottoRanks.count(), lottoRanks.profitRate(lottoTickets.amount())))
}
