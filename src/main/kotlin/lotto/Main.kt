package lotto

import lotto.model.LottoNumberPool
import lotto.model.Lottos
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoCount = InputView.askBudgetQuestion().getBuyableLottoCount()
    ResultView.printLottoCount(lottoCount)

    val myLottos = Lottos(LottoNumberPool, lottoCount)
    ResultView.printMyLottos(myLottos)

    val winningLotto = InputView.askWinningLotto()
    val bonusLottoNumber = InputView.askBonusNumber(winningLotto)
    ResultView.printResult(myLottos, winningLotto, bonusLottoNumber)
}
