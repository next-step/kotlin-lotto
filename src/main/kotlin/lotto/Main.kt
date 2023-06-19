package lotto

import lotto.controller.LottoGame
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val input = InputView()
    val output = ResultView()
    val lottoGame = LottoGame(input, output)
    lottoGame.start()
}
