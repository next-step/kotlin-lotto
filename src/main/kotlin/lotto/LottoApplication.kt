package lotto

import lotto.component.*
import lotto.controller.LottoController
import lotto.controller.LottoViewController
import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val lottoInputFactory = LottoInputFactory(
        LottoInputValidator(),
        LottoNumbersGenerator()
    )
    val lottoViewController = LottoViewController(
        LottoInputView(),
        lottoInputFactory,
        LottoResultView(),
    )
    val lottoController = LottoController(
        Lotto()
    )

    val input = lottoViewController.getLottoInput()
    val result = lottoController.run(input)
    lottoViewController.printLottoResult(result)
}
