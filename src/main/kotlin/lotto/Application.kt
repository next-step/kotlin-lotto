package lotto

import lotto.service.LottoStore
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottoCount = LottoStore.getLottoCount(purchaseAmount)
    OutputView.printLottoCount(lottoCount)
    LottoStore.purchase(purchaseAmount)
}
