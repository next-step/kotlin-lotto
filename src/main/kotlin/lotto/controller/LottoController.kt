package lotto.controller

import lotto.domain.LottoPurchaseManager
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    OutputView.printEnterMoney()
    val money = InputView.inputMoney()

    val lottoPurchaseManager = LottoPurchaseManager()
    val lottoCount = lottoPurchaseManager.getLottoCount(money)
    OutputView.printLottoCount(lottoCount.toString())
}
