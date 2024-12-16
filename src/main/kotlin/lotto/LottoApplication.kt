package lotto

import lotto.domain.Amount
import lotto.domain.LottoGame
import lotto.domain.LottoGameResult
import lotto.repository.LottoRepository
import lotto.view.InputView
import lotto.view.OutPutView


fun main() {
    val lottoGame = LottoGame(LottoRepository())
    val purchaseAmount = InputView.getLottoPurchaseAmount()
    val manualCount = InputView.getLottoManualCount()
    val amount = Amount(purchaseAmount, manualCount)

    val lottoManualNumbers = InputView.getLottoManualNumbers(amount.manualCount)
    val lottoInfo = lottoGame.start(amount, lottoManualNumbers)
    OutPutView.printLottoInfo(lottoInfo)

    val winnerNumbers = InputView.getWinningNumber()
    val lottoGameResult = LottoGameResult(lottoInfo, winnerNumbers)
    OutPutView.printLottoResults(lottoGameResult.getResult(), amount.amount)
}
