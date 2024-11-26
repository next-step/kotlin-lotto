package lotto.application

import lotto.core.LottoWinningStatistics
import lotto.core.Lottos
import lotto.core.WinningChecker
import lotto.core.WinningNumbers
import lotto.core.YieldCalculator

object LottoWinningStatisticsService {
    fun start(
        lottos: Lottos,
        winningNumber: String,
    ): LottoWinningStatistics {
        val winningNumbers = WinningNumbers(winningNumber)
        WinningChecker.markWinningStatus(lottos, winningNumbers)

        return LottoWinningStatistics(lottos, YieldCalculator.calculate(lottos))
    }
}
