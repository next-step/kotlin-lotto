package lotto

import lotto.model.LottoPaper
import lotto.model.WinnerLotto
import lotto.model.getAutoLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.getAmountOfMoney()
    val manualLottoCount = InputView.getManualLottoCount(money)

    val manualLottos = InputView.getManualLotto(manualLottoCount)
    val autoLottos = getAutoLotto(money.spend(manualLottoCount))
    val lottoPaper = LottoPaper(manualLottos.lottoInPaper).add(autoLottos.lottoInPaper)

    ResultView.printLottoCount(manualLottos, autoLottos)
    ResultView.printLottos(lottoPaper)

    val winnerLottoWithoutBonus = InputView.getWinnerLotto()
    val bonus = InputView.getBonusNumber()

    val winnerLotto = WinnerLotto(winnerLottoWithoutBonus, bonus)

    lottoPaper.checkLottoWin(winnerLotto)

    ResultView.printMatchResult(lottoPaper)
    ResultView.printEarningRate(lottoPaper.calculate())
}
