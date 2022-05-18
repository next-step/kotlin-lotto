package lotto

import lotto.contoller.LottoController
import lotto.model.data.Policy645
import lotto.view.input.LottosInputView
import lotto.view.input.WinningLottoInputView
import lotto.view.output.ConsoleOutputView

fun main() {

    val policy = Policy645() // Korean 6/45 Lotto

    val controller = LottoController(
        lottosInputView = LottosInputView(policy),
        winningLottoInputView = WinningLottoInputView(policy),
        outputView = ConsoleOutputView(policy)
    )
    controller.executeGame()
}
