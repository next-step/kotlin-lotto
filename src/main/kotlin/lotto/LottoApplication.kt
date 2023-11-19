package lotto

import lotto.domain.LottoGame
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoGame = LottoGame()
    lottoGame.purchaseLotto(InputView.inputPurchaseMoney())

    ResultView.printPurchasedLottos(lottoGame.lottoTickets)

    val winningLottoNumbers = InputView.inputWinningLottoNumbers()

    val lottoGameResult = lottoGame.generateLottoGameResult(winningLottoNumbers)
    ResultView.printWinningStatistics(lottoGameResult.lottoTicketWinningInfos)
    ResultView.printTotalRateOfReturn(lottoGameResult.totalRateOfReturn)
}
