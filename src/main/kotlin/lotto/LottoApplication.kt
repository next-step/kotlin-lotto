package lotto

import lotto.controller.LottoController
import lotto.ui.InputView
import lotto.ui.ResultView

fun main() {
    val lottoApplication = LottoApplication()
    lottoApplication.run()
}

class LottoApplication {
    fun run() {
        val lottoController = LottoController(
            inputView = InputView(),
            resultView = ResultView()
        )
        lottoController.start()
    }

}