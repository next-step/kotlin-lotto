package lotto

import lotto.model.LottoGame
import lotto.model.LottoNumber
import lotto.model.LottoNumbers
import lotto.model.LottoStat
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

        lottoGame.getLottos()
        val drawResult = lottoGame.draw(LottoNumbers(winningNumber.map { LottoNumber(it) }))

        resultLottoWinner(LottoStat(drawResult, lottoAmount))
    }
}

fun main() {
    val lottoGameController = LottoGameController()
    lottoGameController.process()
}
