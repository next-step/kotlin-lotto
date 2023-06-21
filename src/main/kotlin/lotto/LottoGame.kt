package lotto

import lotto.domain.LottoNumber
import lotto.view.InputView
import lotto.view.ResultView

class LottoGame(
    private val inputView: InputView,
    private val resultView: ResultView
) {

    fun start() {
        val inputAmount = inputView.inputPurchaseAmount()
        val lottoMaker = LottoMaker(inputAmount)
        val lottoList = lottoMaker.createLottoNums()
        resultView.displayPurchasedLotto(lottoList)

        val winningNums = inputView.inputWinningNums().map { LottoNumber(it) }
        val result = LottoResult(winningNums, lottoList)
        resultView.displayResult(result)
    }
}

fun main() {
    val game = LottoGame(InputView(), ResultView())
    game.start()
}