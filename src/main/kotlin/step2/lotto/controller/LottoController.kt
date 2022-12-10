package step2.lotto.controller

import step2.lotto.domain.PurchaseItem
import step2.lotto.io.InputView
import step2.lotto.io.ResultView.printPurchaseItem
import step2.lotto.io.ResultView.printWinningStatistics
import step2.lotto.service.LottoGenerator
import step2.lotto.service.LottoService

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
