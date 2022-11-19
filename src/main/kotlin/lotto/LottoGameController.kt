package lotto

import lotto.model.LottoGame
import lotto.ui.InputView.inputLottoAmount
import lotto.ui.InputView.inputWinningNumber
import lotto.ui.ResultView.resultLottoList
import lotto.ui.ResultView.resultLottoWinner

class LottoGameController {
    fun process() {
        val lottoAmount: Int = inputLottoAmount()
        val lottoGame = LottoGame(lottoAmount)
        resultLottoList(lottoGame.getLottos())

        val winningNumber: List<Int> = inputWinningNumber()
        lottoGame.draw(winningNumber)

        resultLottoWinner(lottoGame)
    }
}

fun main() {
    val lottoGameController = LottoGameController()
    lottoGameController.process()
}
