package lotto

import lotto.model.LottoMachine
import lotto.model.LottoNumberPool
import lotto.model.Lottos
import lotto.model.Lotto
import lotto.model.Money
import lotto.model.WinningLotto
import lotto.model.LottoNumber
import lotto.model.Result
import lotto.view.InputView
import lotto.view.ResultView
import java.math.BigDecimal

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
    val result: List<Result> = lottoMachine.getResult(WinningLotto(winningNumbers, bonusNumber))
    val earningRate: BigDecimal = lottoMachine.getEarningRate()
    ResultView.printResult(result)
    ResultView.printEarningRate(earningRate)
}
