package lotto

import lotto.controller.LottoGameController
import lotto.model.game.LottoGame
import lotto.view.ResultView

fun main() {
    val lottoMachine = LottoGame()
    val lottoGameController = LottoGameController(lottoMachine)

    val totalLottoCount = lottoGameController.ready()
    ResultView.printLottoCount(totalLottoCount)

    val totalLottos = lottoGameController.buy(totalLottoCount)
    ResultView.printMyLottos(totalLottos)

    val winningLotto = lottoGameController.getWinningLotto()
    val gameResult = lottoGameController.match(totalLottos, winningLotto)
    ResultView.printResult(gameResult)

    val earningRate = lottoGameController.getEarningRate(totalLottos, winningLotto)
    ResultView.printEarningRate(earningRate)
}
