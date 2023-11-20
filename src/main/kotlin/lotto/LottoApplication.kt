package lotto

import lotto.component.Lotto
import lotto.component.LottoInputValidator
import lotto.component.LottoResultAnalyzer
import lotto.controller.LottoController
import lotto.controller.LottoViewController
import lotto.model.LottoInput
import lotto.model.LottoNumbers
import lotto.model.WinningNumbers
import lotto.view.LottoInputView
import lotto.view.LottoResultView

fun main() {
    val lottoViewController = LottoViewController(
        LottoInputView(),
        LottoInputValidator(),
        LottoResultView(),
    )
    val lottoResultAnalyzer = LottoResultAnalyzer()
    val lotto = Lotto(lottoResultAnalyzer)
    val lottoController = LottoController(lotto)

    val purchasePrice: Int = lottoViewController.getPurchasePrice()
    val lottoNumbers: List<LottoNumbers> = lottoViewController.getLottoNumbers(purchasePrice)
    lottoViewController.printPurchasedLottoNumbers(lottoNumbers)
    val winningNumbers: WinningNumbers = lottoViewController.getWinningNumbers()
    val bonusNumber: Int = lottoViewController.getBonusNumber()

    val input = LottoInput(lottoNumbers, winningNumbers, bonusNumber)
    val result = lottoController.run(input)

    lottoViewController.printLottoResult(result)
}
