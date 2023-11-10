package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoStatCalculator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()

    val purchasedLottoList = LottoMachine.purchase(purchaseAmount)

    ResultView.showPurchasedLotto(purchasedLottoList)

    val lastWinnerLotto = InputView.getLastWinnerLotto()

    val lottoStatResult = LottoStatCalculator(lastWinnerLotto).getStat(purchasedLottoList)

    ResultView.showLottoStatResult(lottoStatResult)
}
