package lotto

import lotto.contoller.LottoController
import lotto.model.RangeLottoBuilder
import lotto.model.data.Policy645
import lotto.view.input.PurchaseCountInputView
import lotto.view.input.WinningLottoInputView
import lotto.view.output.ConsoleOutputView

fun main() {

    val policy = Policy645() // Korean 6/45 Lotto

    val controller = LottoController(
        lottoBuilder = RangeLottoBuilder(policy),
        lottoCountInputView = PurchaseCountInputView(policy),
        winningLottoInputView = WinningLottoInputView(policy),
        outputView = ConsoleOutputView(policy)
    )
    controller.executeGame()
}
