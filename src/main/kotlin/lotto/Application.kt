package lotto

import lotto.domain.LottoNumber
import lotto.service.LottoStore
import lotto.util.getIntegersAfterSplit
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val lottos = LottoStore.purchase(purchaseAmount)
    OutputView.printLottos(lottos)
    val lastWinningNumbers = InputView.getLastWinningNumbers()
    val winningLotto = lastWinningNumbers.getIntegersAfterSplit(",").map { LottoNumber(it) }
}
