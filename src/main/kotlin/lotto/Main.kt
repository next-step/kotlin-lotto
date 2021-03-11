package lotto

import lotto.model.InputReader
import lotto.model.LottoMachine
import lotto.model.Lottos
import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.model.WinningLotto
import lotto.model.Money
import lotto.model.Result
import lotto.view.InputView
import lotto.view.ResultView
import java.math.BigDecimal

fun main() {
    val lottoMachine = LottoMachine()
    val inputReader = InputReader()

    InputView.printBudgetQuestion()
    val budget: Money = inputReader.readBudget()
    val availableCount = lottoMachine.insertMoney(budget)
    ResultView.printLottoCount(availableCount)

    val myLottos: Lottos = lottoMachine.buy()
    ResultView.printMyLottos(myLottos)

    InputView.printWinningNumberQuestion()
    val winningNumbers: Lotto = inputReader.readWinningLottoNumbers()

    InputView.printBonusBallQuestion()
    val bonusNumber: LottoNumber = inputReader.readBonusNumber(winningNumbers)
    val winningLotto = WinningLotto(winningNumbers, bonusNumber)

    val result: List<Result> = lottoMachine.getResult(winningLotto)
    ResultView.printResult(result)

    val earningRate: BigDecimal = lottoMachine.getEarningRate()
    ResultView.printEarningRate(earningRate)
}
