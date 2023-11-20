package lotto

import lotto.domain.LottoGame
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseMoney = InputView.inputPurchaseMoney()

    val lottoGame = LottoGame(purchaseMoney)

    ResultView.printPurchasedLottos(lottoGame.lottoTickets)

    val winningLottoNumbers = InputView.inputWinningLottoNumbers()

    val lottoGameResult = lottoGame.generateLottoGameResult(winningLottoNumbers)
    ResultView.printWinningStatistics(lottoGameResult.lottoTicketWinningInfos)
    ResultView.printTotalRateOfReturn(lottoGameResult.totalRateOfReturn)
}
