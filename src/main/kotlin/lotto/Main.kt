package lotto

import lotto.model.input.InputReader
import lotto.model.game.LottoGame
import lotto.model.game.LottoMachine
import lotto.view.ResultView

fun main() {
    val lottoMachine = LottoMachine()
    val inputReader = InputReader()
    val lottoGame = LottoGame(lottoMachine, inputReader)

    ResultView.printLottoCount(lottoGame.ready())
    ResultView.printMyLottos(lottoGame.buy())
    ResultView.printResult(lottoGame.getResult())
    ResultView.printEarningRate(lottoGame.getEarningRate())
}
