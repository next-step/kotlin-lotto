package lotto.controller

import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val lottoService = LottoService()

    val purchaseAmount = InputView.getPurchaseAmount()
    ResultView.printPurchaseAmount(purchaseAmount)

    val lottoList = lottoService.getLottoNumbers(purchaseAmount)
    ResultView.printLottoList(lottoList)

    val winningNumbers = InputView.getWinningNumbers()
    val lottoResults = lottoService.getLottoResult(lottoList, winningNumbers)

    ResultView.printResult(lottoResults)
}
