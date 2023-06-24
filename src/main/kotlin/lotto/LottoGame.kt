package lotto

import lotto.domain.*
import lotto.view.InputView
import lotto.view.ResultView

class LottoGame(
    private val inputView: InputView,
    private val resultView: ResultView
) {

    fun start() {
        val inputAmount = inputView.inputPurchaseAmount()
        val lottoMaker = LottoPurchaser(AutoLottoGenerator())
        val lottoList = lottoMaker.purchase(inputAmount)
        resultView.displayPurchasedLotto(lottoList)

        val winningLotto = Lotto(inputView.inputWinningNums().map { LottoNumber(it) }.toSet())
        val result = LottoResult(winningLotto, lottoList)
        resultView.displayResult(result)
    }
}

fun main() {
    val game = LottoGame(InputView(), ResultView())
    game.start()
}
