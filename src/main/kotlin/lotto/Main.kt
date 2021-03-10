package lotto

import lotto.model.*
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val budget = InputView.askBudgetQuestion()
    val lottoCount = Money(budget).getBuyableLottoCount()
    ResultView.printLottoCount(lottoCount)

    val myLottos = Lottos(LottoNumberPool, lottoCount)
    ResultView.printMyLottos(myLottos)

    val winningNumbers = InputView.askWinningLottoNumbers()
    val winningLottoNumbers = Lotto(winningNumbers)
    val bonusLottoNumber = InputView.askBonusNumber(winningLottoNumbers)
    val winningLotto = WinningLotto(winningLottoNumbers, LottoNumber(bonusLottoNumber))
    ResultView.printResult(myLottos, winningLotto)
}
