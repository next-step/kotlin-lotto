package lotto.controller

import lotto.domain.LottoNumberProvider
import lotto.domain.LottoPurchaseManager
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    OutputView.printEnterMoney()
    val money = InputView.inputMoney()

    val lottoPurchaseManager = LottoPurchaseManager()
    val lottoTryCount = lottoPurchaseManager.getLottoCount(money)
    OutputView.printLottoCount(lottoTryCount.toString())

    val lottoNumberProvider = LottoNumberProvider()
    val lotto = lottoNumberProvider.getLotto(lottoTryCount)
    OutputView.printLottoList(lotto)

    OutputView.printJackpotNumber()
    val jackpotNumbers = InputView.inputJackpotNumber()
}
