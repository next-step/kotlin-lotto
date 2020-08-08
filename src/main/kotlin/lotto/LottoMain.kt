package lotto

import lotto.model.LottoChecker
import lotto.model.WinnerLotto
import lotto.model.getAutoLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.getAmountOfMoney()
    val manualLottoCount = InputView.getManualLottoCount(money)

    val manualLottos = InputView.getManualLotto(manualLottoCount)
    val autoLottos = getAutoLotto(money.spend(manualLottoCount))
    val lottoPaper = manualLottos.add(autoLottos)

    ResultView.printLottoCount(manualLottos, autoLottos)
    ResultView.printLottos(lottoPaper)

    val winnerLottoWithoutBonus = InputView.getWinnerLotto()
    val bonus = InputView.getBonusNumber()

    val winnerLotto = WinnerLotto(winnerLottoWithoutBonus, bonus)
    val checker = LottoChecker(winnerLotto, lottoPaper)

    ResultView.printMatchResult(checker.getLottos())
    ResultView.printEarningRate(checker.getEarningRate())
}
