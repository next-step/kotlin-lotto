package lotto

import lotto.component.Lotto
import lotto.component.LottoInputValidator
import lotto.component.LottoResultAnalyzer
import lotto.controller.LottoController
import lotto.controller.LottoViewController
import lotto.service.LottoInputService
import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val lottoInputService = LottoInputService(
        LottoInputValidator()
    )
    val lottoViewController = LottoViewController(
        LottoInputView(),
        lottoInputService,
        LottoResultView(),
    )
    val lottoResultAnalyzer = LottoResultAnalyzer()
    val lotto = Lotto(lottoResultAnalyzer)
    val lottoController = LottoController(lotto)

    val input = lottoViewController.getLottoInput()
    val result = lottoController.run(input)
    lottoViewController.printLottoResult(result)
}
