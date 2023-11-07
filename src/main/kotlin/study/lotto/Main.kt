package study.lotto

import study.lotto.controller.LottoController
import study.lotto.view.InputView
import study.lotto.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val lottoController = LottoController(inputView, resultView)

    lottoController.run()
}
