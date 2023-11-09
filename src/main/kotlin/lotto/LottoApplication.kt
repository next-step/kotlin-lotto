package lotto

import lotto.component.Lotto
import lotto.component.LottoController
import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val controller = LottoController(
        LottoInputView(),
        LottoResultView(),
        Lotto()
    )

    controller.run()
}
