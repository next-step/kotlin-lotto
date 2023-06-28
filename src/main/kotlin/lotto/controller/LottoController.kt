package lotto.controller

import lotto.domain.LottoPurchase.Companion.DEFAULT_PRICE
import lotto.service.LottoShopService
import lotto.view.InputView
import lotto.view.ResultView
import lotto.vo.OrderRequest

class LottoController {
    private val inputView = InputView()
    private val resultView = ResultView()

    fun run() {
        val budget = inputView.inputPurchasePrice()
        val manualAmount = inputView.inputManualPurchaseAmount()
        val manualLottosNumbers = inputView.inputManualLottos(manualAmount)

        val orderRequest = OrderRequest(budget, DEFAULT_PRICE, manualLottosNumbers)
        val lottoShopService = LottoShopService()
        val receipt = lottoShopService.buy(orderRequest)
        val lottos = receipt.lottos

        resultView.printPurchaseAmount(receipt.manualAmount, receipt.autoAmount)
        resultView.printLottos(lottos)

        val winningLotto = inputView.inputLastWeekWinningLotto()
        val statistics = lottoShopService.winning(winningLotto, lottos, budget)
        resultView.printWinningResult(statistics)
    }
}

fun main() {
    LottoController().run()
}
