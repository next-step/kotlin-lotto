package lotto.controller

import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoService = LottoService()

    val purchaseAmount = InputView.getPurchaseAmount()
    val manualLottoCount = InputView.getManualLottoNumberCount()
    val manualLottos = InputView.getManualLottoNumbers(manualLottoCount)

    val lottoList = lottoService.getLottoNumbers(
        purchaseAmount = purchaseAmount,
        manualLottos = manualLottos,
    )
    ResultView.printLottoList(lottoList, manualLottoCount)

    val winningNumbers = InputView.getWinningNumbers()
    val lottoResults = lottoService.getLottoResult(lottoList, winningNumbers)

    ResultView.printResult(lottoResults)
}
