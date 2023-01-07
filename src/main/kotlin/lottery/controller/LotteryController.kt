package lottery.controller

import lottery.domain.lotto.Lotto
import lottery.domain.winningresult.WinningResult
import lottery.service.CalculatorService
import lottery.service.LottoService
import lottery.service.WinningResultService
import lottery.ui.ViewService

class LotteryController(
    private val viewService: ViewService,
    private val lottoService: LottoService,
    private val winningResultService: WinningResultService,
    private val calculatorService: CalculatorService,
) {
    fun run() {
        val amount = viewService.getPurchasingAmount()
        val lottos = purchaseLottos(amount)

        val result = drawWinners(lottos)

        reportRateOfReturn(amount, result)
    }

    private fun purchaseLottos(amount: Long): List<Lotto> {
        return lottoService.issue(amount).also {
            viewService.showPurchasingResult(it)
        }
    }

    private fun drawWinners(lottos: List<Lotto>): WinningResult {
        val winningNumber = viewService.getWinningNumber()
        return winningResultService.draw(lottos, winningNumber)
            .also {
                viewService.showResultOfWinning(it)
            }
    }

    private fun reportRateOfReturn(amount: Long, result: WinningResult) {
        val rateOfReturn = calculatorService.rateOfReturn(amount, result)
        viewService.showRateOfReturn(rateOfReturn)
    }

}
