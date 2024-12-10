package autolotto

import autolotto.configuration.AutoLottoConfiguration
import autolotto.controller.AutoLottoController
import autolotto.view.InputView
import autolotto.view.OutPutView

private val autoLottoController: AutoLottoController =
    AutoLottoConfiguration().autoLottoController()

fun main() {
    val amount = InputView.getLottoPurchaseAmount()
    InputView.printLottoGameCount(amount.getLottoGameCount())

    val createLottoInfo = autoLottoController.start(amount.getLottoGameCount())
    OutPutView.printLottoInfo(createLottoInfo)

    val winnerNumbers = InputView.getWinningNumber()
    val resultResponse = autoLottoController.getResult(winnerNumbers)
    OutPutView.printLottoResults(resultResponse, amount.amount)
}
