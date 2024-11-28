package lotto.application

import lotto.core.LottoWinningStatistics
import lotto.core.Lottos
import lotto.core.WinningNumbers

object LottoWinningStatisticsService {
    fun start(
        lottos: Lottos,
        numbers: List<Int>,
    ): LottoWinningStatistics {
        val winningNumbers = WinningNumbers(numbers)
        val lottoResult = lottos.countWinningRanks(winningNumbers)
        return LottoWinningStatistics(lottoResult, lottoResult.calculateYield(lottos.size))
    }
}
