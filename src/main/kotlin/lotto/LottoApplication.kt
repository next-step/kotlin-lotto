package lotto

import lotto.component.*
import lotto.controller.LottoController
import lotto.controller.LottoViewController
import lotto.service.LottoInputService
import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val lottoInputService = LottoInputService(
        LottoInputValidator(),
        LottoNumbersGenerator()
    )
    val lottoViewController = LottoViewController(
        LottoInputView(),
        lottoInputService,
        LottoResultView(),
    )
    val lottoController = LottoController(
        Lotto()
    )

    val input = lottoViewController.getLottoInput()
    val result = lottoController.run(input)
    lottoViewController.printLottoResult(result)
}
