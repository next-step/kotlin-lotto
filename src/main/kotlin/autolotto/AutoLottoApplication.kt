package autolotto

import autolotto.configuration.AutoLottoConfiguration
import autolotto.controller.AutoLottoController
import autolotto.view.InputView
import autolotto.view.OutPutView

private val autoLottoController: AutoLottoController =
    AutoLottoConfiguration().autoLottoController()

fun main() {
    val amount = InputView.getLottoPurchaseAmount()
    InputView.printLottoGameCount(amount)

    val gameCount = InputView.getLottoGameCount(amount)
    val createLottoInfo = autoLottoController.start(gameCount)
    OutPutView.printLottoInfo(createLottoInfo)

    val winnerNumbers = InputView.getWinningNumber()
    val resultResponse = autoLottoController.getResult(winnerNumbers, amount)
    OutPutView.printLottoResults(resultResponse)
}
