package lotto.client

import lotto.LottoMachine
import lotto.Lottos
import lotto.rank.LottoRank
import lotto.statistics.Profit
import lotto.statistics.WinningStatistics
import lotto.view.InputView
import lotto.view.ResultView

class LottoClient(
    private val lottoMachine: LottoMachine,
    private val winningStatistics: WinningStatistics,
) {
    fun run() {
        val amount = InputView.inputPurchaseAmount()
        val lottoCount = getLottoCount(amount)
        ResultView.printLottoCount(lottoCount)

        val lottos = lottoMachine.generate(lottoCount)
        ResultView.printLottoList(lottos)

        val lottoRanks = calculateStatistics(lottos)
        ResultView.printStatistics(lottoRanks = lottoRanks)

        val profit = calculateProfit(lottoRanks = lottoRanks, amount = amount)
        ResultView.printProfit(profit)
    }

    private fun getLottoCount(purchaseAmount: Int): Int = (purchaseAmount / LOTTO_PRICE)

    private fun calculateStatistics(lottos: Lottos): List<LottoRank> {
        val winningNumbers = InputView.inputLastWeekWinningNumbers()
        return winningStatistics.evaluate(lottos = lottos, winningNumbers = winningNumbers)
    }

    private fun calculateProfit(
        lottoRanks: List<LottoRank>,
        amount: Int,
    ): Double = Profit(winningAmount = lottoRanks.sumOf { it.prize }, purchaseAmount = amount).yield()

    companion object {
        val LOTTO_PRICE = 1_000
    }
}
