package lotto.application.console

import lotto.domain.LottoGame
import lotto.domain.LottoMachine
import lotto.domain.RandomLottoFactory

fun main() {

    val inputView = InputView()
    val resultView = ResultView()

    val cost = inputView.inputCost()
    val lottoMachine = LottoMachine(RandomLottoFactory())
    val lottos = lottoMachine.buyAuto(cost)

    resultView.printLottos(lottos)

    val winningNumbers = inputView.inputWinningNumbers()
    val lottoGame = LottoGame(winningNumbers)

    val summary = lottoGame.match(lottos)
    resultView.printSummary(summary)
}