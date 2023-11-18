package lotto

import lotto.component.Lotto
import lotto.component.LottoInputValidator
import lotto.component.LottoResultAnalyzer
import lotto.controller.LottoController
import lotto.controller.LottoViewController
import lotto.component.LottoInputConverter
import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val lottoInputConverter = LottoInputConverter(
        LottoInputValidator()
    )
    val lottoViewController = LottoViewController(
        LottoInputView(),
        lottoInputConverter,
        LottoResultView(),
    )
    val lottoResultAnalyzer = LottoResultAnalyzer()
    val lotto = Lotto(lottoResultAnalyzer)
    val lottoController = LottoController(lotto)

    val input = lottoViewController.getLottoInput()
    val result = lottoController.run(input)
    lottoViewController.printLottoResult(result)
}
