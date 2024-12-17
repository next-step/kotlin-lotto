package lotto

import lotto.controller.LottoController
import lotto.domain.Amount
import lotto.domain.LottoGame
import lotto.repository.LottoRepository
import lotto.view.InputView
import lotto.view.OutPutView

private val lottoController = LottoController(LottoGame(LottoRepository()))

fun main() {
    val purchaseAmount = InputView.getLottoPurchaseAmount()
    val manualCount = InputView.getLottoManualCount()
    val amount = Amount(purchaseAmount, manualCount)
    val lottoManualNumbers = InputView.getLottoManualNumbers(amount.manualCount)

    val lottoInfo = lottoController.start(amount, lottoManualNumbers)
    OutPutView.printLottoInfo(lottoInfo)

    val winnerNumbers = InputView.getWinningNumber()

    val lottoGameResult = lottoController.getLottoGameResult(lottoInfo, winnerNumbers)
    OutPutView.printLottoResults(lottoGameResult.getResult(), amount.amount)
}
