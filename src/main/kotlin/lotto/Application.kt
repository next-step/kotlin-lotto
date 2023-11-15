package lotto

import lotto.domain.*
import lotto.util.getIntegersAfterSplit
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val userLotto = LottoStore.purchase(purchaseAmount, RandomLottoGenerator())
    OutputView.printLottos(userLotto)
    val lastWinningNumbers = InputView.getLastWinningNumbers()
    val bonusBall = InputView.getBonusBall()
    val winningLotto = Lotto.fromInts(lastWinningNumbers.getIntegersAfterSplit(","))
    val lottoResult = LottoResult(userLotto, winningLotto, LottoNumber(bonusBall))
    OutputView.printResult(lottoResult)
}
