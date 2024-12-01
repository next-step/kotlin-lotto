package lotto.step4

import lotto.step4.domain.AutoLottoPurchasableMoneyCalculator
import lotto.step4.domain.LottoGame
import lotto.step4.domain.LottoNumberPicker
import lotto.step4.domain.LottoPurchaseManager
import lotto.step4.view.InputView
import lotto.step4.view.OutputView

fun main() {
    val money = InputView.getPurchaseAmount()
    val manualPurchaseCount = InputView.getManualPurchaseCount(money)
    val manualPurchasedLottos = InputView.getManualPurchaseNumbers(manualPurchaseCount)
    val autoPurchaseMoney = AutoLottoPurchasableMoneyCalculator.calculateMoney(money, manualPurchaseCount)
    val autoPurchasedLottos = LottoPurchaseManager(LottoNumberPicker()).purchase(autoPurchaseMoney)
    OutputView.printPurchaseResult(manualLottos = manualPurchasedLottos, autoLottos = autoPurchasedLottos)
    val totalPurchasedLottos = manualPurchasedLottos.add(autoPurchasedLottos)

    val lastWeekWinningNumbers = InputView.getLastWeekWinningNumbers()
    val bonusNumber = InputView.getBonusNumber()
    val winningStatistics =
        LottoGame().execute(
            lastWeekWinningNumbers = lastWeekWinningNumbers,
            lottos = totalPurchasedLottos,
            bonusNumber = bonusNumber,
        )
    OutputView.printStatistics(winningStatistics)
}
