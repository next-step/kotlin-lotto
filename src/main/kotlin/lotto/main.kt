package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoStatCalculator
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()

    val manualLottoCount = InputView.getManualLottoCount()

    val manualLottery = InputView.getManualLotto(count = manualLottoCount)

    val purchasedLottery = LottoMachine.purchase(
        purchaseAmount = purchaseAmount,
        manualLottery = manualLottery
    )

    ResultView.showPurchasedLottery(purchasedLottery)

    val lastWinnerLotto = InputView.getLastWinnerLotto()

    val lottoStatResult = LottoStatCalculator(lastWinnerLotto).getStat(purchasedLottery.getLottery())

    ResultView.showLottoStatResult(lottoStatResult)
}
