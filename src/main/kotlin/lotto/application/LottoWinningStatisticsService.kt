package lotto.application

import lotto.core.LottoWinningStatistics
import lotto.core.Lottos
import lotto.core.WinningNumbers
import lotto.core.YieldCalculator

object LottoWinningStatisticsService {
    fun start(
        lottos: Lottos,
        numbers: List<Int>,
    ): LottoWinningStatistics {
        val winningNumbers = WinningNumbers(numbers)
        val winningRankCount = lottos.countWinningRanks(winningNumbers)

        return LottoWinningStatistics(winningRankCount, YieldCalculator.calculate(winningRankCount, lottos.size))
    }
}
