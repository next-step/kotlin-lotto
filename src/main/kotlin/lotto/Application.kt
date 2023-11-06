package lotto

import lotto.service.LottoCounter
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoCount = LottoCounter.getLottoCount(purchaseAmount)
    OutputView.printLottoCount(lottoCount)
    LottoCounter.purchase(purchaseAmount)
}
