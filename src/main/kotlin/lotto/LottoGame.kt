package lotto

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

        val winningNums = inputView.inputWinningNums()
        val result = LottoResult(winningNums, lottoList)
        resultView.displayResult(result)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val game = LottoGame(InputView(), ResultView())
            game.start()
        }
    }
}