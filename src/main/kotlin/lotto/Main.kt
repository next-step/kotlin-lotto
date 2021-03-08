package lotto

import lotto.model.LottoNumberPool
import lotto.model.Lottos
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val budget = InputView.askBudgetQuestion()
    val lottoCount = budget.getBuyableLottoCount()
    ResultView.printLottoCount(lottoCount)

    val myLottos = Lottos(LottoNumberPool, lottoCount)
    ResultView.printMyLottos(myLottos)

    val winningLotto = InputView.askWinningLotto()
    ResultView.printResult(myLottos, winningLotto)
}
