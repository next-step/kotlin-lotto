package lotto

import lotto.component.*
import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val lottoInputFactory = LottoInputFactory(
        LottoInputValidator(),
        LottoNumbersGenerator()
    )
    val controller = LottoController(
        LottoInputView(),
        lottoInputFactory,
        LottoResultView(),
        Lotto()
    )

    controller.run()
}
