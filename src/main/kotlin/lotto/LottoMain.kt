package lotto

import lotto.model.Lotto
import lotto.model.LottoChecker
import lotto.model.buyLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.getAmountOfMoney()
    val lottos = buyLotto(money)

    ResultView.printLottoCount(lottos)
    ResultView.printLottos(lottos)

    val winnerNumbers = InputView.getWinnerLotto()
    val winnerLotto = Lotto(winnerNumbers.toMutableList())
    val checker = LottoChecker(winnerLotto, lottos)

    ResultView.printMatchResult(checker.getLottos())
    ResultView.printEarningRate(checker.getEarningRate())
}
