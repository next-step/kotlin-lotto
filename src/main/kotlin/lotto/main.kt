package lotto

import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()

    val manualLottoCount = InputView.getManualLottoCount()

    val manualLottery = InputView.getManualLotto(count = manualLottoCount)

    val purchasedLottoList = LottoMachine.purchase(
        purchaseAmount = purchaseAmount,
        manualLottery = manualLottery
    )

    ResultView.showPurchasedLotto(purchasedLottoList)

    // val lastWinnerLotto = InputView.getLastWinnerLotto()

    // val lottoStatResult = LottoStatCalculator(lastWinnerLotto).getStat(purchasedLottoList)

    // ResultView.showLottoStatResult(lottoStatResult)
}
