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

    val budget: Money = InputView.askBudgetQuestion()
    lottoMachine.insertMoney(budget)
    ResultView.printLottoCount(lottoMachine)

    val myLottos = Lottos(LottoNumberPool, lottoMachine.getAvailableCount())
    ResultView.printMyLottos(myLottos)

    val winningNumbers = InputView.askWinningLottoNumbers()
    val winningLottoNumbers = Lotto(winningNumbers)
    val bonusLottoNumber = InputView.askBonusNumber(winningLottoNumbers)
    val winningLotto = WinningLotto(winningLottoNumbers, LottoNumber(bonusLottoNumber))
    ResultView.printResult(myLottos, winningLotto)
}
