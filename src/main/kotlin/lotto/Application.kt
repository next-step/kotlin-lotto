package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.service.LottoStore
import lotto.util.getIntegersAfterSplit
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val userLotto = LottoStore.purchase(purchaseAmount)
    OutputView.printLottos(userLotto)
    val lastWinningNumbers = InputView.getLastWinningNumbers()
    val winningLotto = Lotto(lastWinningNumbers.getIntegersAfterSplit(",").map { LottoNumber(it) })
    val lottoResult = LottoResult(userLotto, winningLotto)
    val profitRate = lottoResult.calculateProfitRate()
}
