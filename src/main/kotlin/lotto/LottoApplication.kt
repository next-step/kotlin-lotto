package lotto

import lotto.configuration.AutoLottoConfiguration
import lotto.controller.LottoController
import lotto.view.InputView
import lotto.view.OutPutView

private val lottoController: LottoController =
    AutoLottoConfiguration().autoLottoController()

fun main() {
    val amount = InputView.getLottoPurchaseAmount()
    InputView.printLottoGameCount(amount.lottoGameCount)

    val createLottoInfo = lottoController.start(amount.lottoGameCount)
    OutPutView.printLottoInfo(createLottoInfo)

    val winnerNumbers = InputView.getWinningNumber()
    val resultResponse = lottoController.getResult(winnerNumbers)
    OutPutView.printLottoResults(resultResponse, amount.amount)
}
