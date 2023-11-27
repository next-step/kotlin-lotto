package lotto

import lotto.component.Lotto
import lotto.component.LottoInputValidator
import lotto.component.LottoResultAnalyzer
import lotto.controller.LottoController
import lotto.controller.LottoViewController
import lotto.model.*
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

    val purchasePrice: PurchasePrice = lottoViewController.getPurchasePrice()

    val manualLottoNumbersCount: Int = lottoViewController.getManualLottoNumbersCount()
    val (manualLottoNumbers, extraPurchasePrice) = lottoViewController.getManualLottoNumbers(manualLottoNumbersCount, purchasePrice)
    val lottoNumbers: List<LottoNumbers> = lottoViewController.getLottoNumbers(extraPurchasePrice)

    lottoViewController.printPurchasedLottoNumbers(manualLottoNumbers, lottoNumbers)

    val winningNumbers: WinningNumbers = lottoViewController.getWinningNumbers()
    val bonusNumber: LottoNumber = lottoViewController.getBonusNumber(winningNumbers)

    val input = LottoInput(manualLottoNumbers + lottoNumbers, winningNumbers, bonusNumber)
    val result = lottoController.run(input)

    lottoViewController.printLottoResult(result)
}
