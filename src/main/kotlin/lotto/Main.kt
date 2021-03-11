package lotto

import lotto.model.LottoMachine
import lotto.model.Lottos
import lotto.model.Lotto
import lotto.model.Money
import lotto.model.WinningLotto
import lotto.model.LottoNumber
import lotto.model.Result
import lotto.view.InputReader
import lotto.view.InputView
import lotto.view.ResultView
import java.math.BigDecimal

fun main() {
    val lottoMachine = LottoMachine()
    val inputReader = InputReader()

    InputView.printBudgetQuestion()
    val budget: Money = inputReader.readBudget()
    lottoMachine.insertMoney(budget)
    val myLottos: Lottos = lottoMachine.buy()
    ResultView.printLottoCount(lottoMachine)
    ResultView.printMyLottos(myLottos)

    InputView.printWinningNumberQuestion()
    val winningNumbers: Lotto = inputReader.readWinningLottoNumbers()

    InputView.printBonusBallQuestion()
    val bonusNumber: LottoNumber = inputReader.readBonusNumber(winningNumbers)
    val result: List<Result> = lottoMachine.getResult(WinningLotto(winningNumbers, bonusNumber))
    val earningRate: BigDecimal = lottoMachine.getEarningRate()
    ResultView.printResult(result)
    ResultView.printEarningRate(earningRate)
}
