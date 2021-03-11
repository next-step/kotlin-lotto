package lotto

import lotto.model.LottoMachine
import lotto.model.LottoNumberPool
import lotto.model.Lottos
import lotto.model.Lotto
import lotto.model.Money
import lotto.model.WinningLotto
import lotto.model.LottoNumber
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoMachine = LottoMachine()
    val lottoPool = LottoNumberPool

    val budget: Money = InputView.askBudgetQuestion()
    lottoMachine.insertMoney(budget)
    ResultView.printLottoCount(lottoMachine)

    val myLottos: Lottos = lottoMachine.buy(lottoPool)
    ResultView.printMyLottos(myLottos)

    val winningNumbers: Lotto = InputView.askWinningLottoNumbers()
    val bonusNumber: LottoNumber = InputView.askBonusNumber(winningNumbers)
    val winningLotto = WinningLotto(winningNumbers, bonusNumber)
    ResultView.printResult(myLottos, winningLotto)
}
