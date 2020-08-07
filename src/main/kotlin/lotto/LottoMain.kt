package lotto

import lotto.model.LottoChecker
import lotto.model.WinnerLotto
import lotto.model.buyLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.getAmountOfMoney()
    val lottos = buyLotto(money)

    ResultView.printLottoCount(lottos)
    ResultView.printLottos(lottos)

    val winnerLottoWithoutBonus = InputView.getWinnerLotto()
    val bonus = InputView.getBonusNumber()

    val winnerLotto = WinnerLotto(winnerLottoWithoutBonus, bonus)
    val checker = LottoChecker(winnerLotto, lottos)

    ResultView.printMatchResult(checker.getLottos())
    ResultView.printEarningRate(checker.getEarningRate())
}
