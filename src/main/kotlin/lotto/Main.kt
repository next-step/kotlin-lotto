package lotto

import lotto.controller.LottoController
import lotto.uI.InputView

fun main() {
    val lottoController = LottoController()

    val money = InputView.inputMoney()

    val manualLottoCount = InputView.inputManualLottoCount()

    val lottoList = lottoController.purchase(money, manualLottoCount)

    lottoController.showStatistic(money, lottoList)
}
