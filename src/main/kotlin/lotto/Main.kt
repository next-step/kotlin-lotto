package lotto

import lotto.model.InputReader
import lotto.model.LottoGame
import lotto.model.LottoMachine
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
