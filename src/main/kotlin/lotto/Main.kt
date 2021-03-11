package lotto

import lotto.model.game.LottoGame
import lotto.model.game.LottoGameController
import lotto.model.game.LottoMachine
import lotto.model.input.InputReader

fun main() {
    val lottoMachine = LottoMachine()
    val inputReader = InputReader()
    val lottoGame = LottoGame(lottoMachine, inputReader)
    val lottoGameController = LottoGameController(lottoGame)

    lottoGameController.ready()
    lottoGameController.buy(inputReader)
    lottoGameController.match()
    lottoGameController.getEarningRate()
}
