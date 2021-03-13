package lotto

import lotto.model.game.LottoGame
import lotto.controller.LottoGameController
import lotto.model.game.LottoMachine
import lotto.view.InputReader

fun main() {
    val lottoMachine = LottoMachine()
    val inputReader = InputReader()
    val lottoGame = LottoGame(lottoMachine, inputReader)
    val lottoGameController = LottoGameController(lottoGame)

    lottoGameController.ready()
    lottoGameController.buy()
    lottoGameController.match()
    lottoGameController.getEarningRate()
}
