package lotto.controller

import lotto.domain.PurchaseItem
import lotto.io.InputView
import lotto.io.ResultView.printPurchaseItem
import lotto.io.ResultView.printWinningStatistics
import lotto.service.LottoGenerator
import lotto.service.LottoService

class LottoController(private val lottoGenerator: LottoGenerator) {
    private val lottoService: LottoService = LottoService()

    fun playLotto() {
        val buyAmount = InputView.inputBuyAmount()
        val lottos = lottoGenerator.generate(buyAmount)
        val purchaseItem = PurchaseItem.of(buyAmount, lottos)
        printPurchaseItem(purchaseItem)

        val winningNumber = InputView.inputWinningNumber()
        val playResult = lottoService.play(purchaseItem, winningNumber)
        printWinningStatistics(purchaseItem, playResult)
    }
}
