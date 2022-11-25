package lotto

import lotto.controller.LottoController
import lotto.uI.InputView

fun main() {
    val lottoController = LottoController()

    val money = InputView.inputMoney()

    val lottoList = lottoController.purchase(money)

    lottoController.showStatistic(money, lottoList)
}
