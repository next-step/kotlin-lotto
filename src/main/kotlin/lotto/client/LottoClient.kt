package lotto.client

import lotto.Generator
import lotto.statistics.ProfitCalculator
import lotto.statistics.WinningStatistics
import lotto.view.InputView
import lotto.view.ResultView

class LottoClient(
    private val generator: Generator,
    private val winningStatistics: WinningStatistics,
) {
    fun run() {
        val amount = InputView.inputPurchaseAmount()
        val lottoCount = getLottoCount(amount)
        ResultView.printLottoCount(lottoCount)

        val winningNumbers = InputView.inputLastWeekWinningNumbers()

        val lottos = generator.generate(lottoCount)
        val result = winningStatistics.evaluate(lottos = lottos, winningNumbers = winningNumbers)
        val profit = ProfitCalculator.evaluate(winningAmount = result.sumOf { it.prize }, purchaseAmount = amount)
    }

    private fun getLottoCount(purchaseAmount: Int): Int = (purchaseAmount / LOTTO_PRICE)

    companion object {
        val LOTTO_PRICE = 1_000
    }
}
