package lotto

import lotto.model.input.InputReader
import lotto.model.game.LottoGame
import lotto.model.game.LottoMachine
import lotto.model.input.Money
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoMachine = LottoMachine()
    val inputReader = InputReader()
    val lottoGame = LottoGame(lottoMachine, inputReader)

    InputView.printBudgetQuestion()
    val budget: Money = inputReader.readBudget()

    ResultView.printLottoCount(lottoGame.ready(budget))
    ResultView.printMyLottos(lottoGame.buy())
    ResultView.printResult(lottoGame.getResult())
    ResultView.printEarningRate(lottoGame.getEarningRate())
}
