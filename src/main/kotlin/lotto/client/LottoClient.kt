package lotto.client

import lotto.Generator
import lotto.rank.LottoRank
import lotto.statistics.WinningStatistics
import lotto.view.InputView

class LottoClient(
    private val generator: Generator,
    private val winningStatistics: WinningStatistics,
) {
    fun run(): List<LottoRank> {
        val lottoCount = InputView.inputPurchaseAmount()

        val winningNumbers = InputView.inputLastWeekWinningNumbers()

        val lottos = generator.generate(lottoCount)
        return winningStatistics.evaluate(lottos = lottos, winningNumbers = winningNumbers)
    }
}
