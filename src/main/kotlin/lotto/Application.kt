package lotto

import lotto.service.LottoStore
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottos = LottoStore.purchase(purchaseAmount)
    OutputView.printLottos(lottos)
}
