package lotto

import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val purchased = InputView().getPurchaseAmount()
    val lottoManager = LottoManager(purchased)

    println(lottoManager.purchased)
    OutputView().printPurchasedAmount(lottoManager.getLottoList().size)
    OutputView().printLottoList(lottoManager.getLottoList())

    lottoManager.setWinningNumbers(InputView().getWinningNumbers())
}
