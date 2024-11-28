package lotto.application

import lotto.core.LottoWinningStatistics
import lotto.core.Lottos
import lotto.core.WinningNumbers

object LottoWinningStatisticsService {
    fun start(
        lottos: Lottos,
        numbers: List<Int>,
        bonusNumber: Int,
    ): LottoWinningStatistics {
        val lottoResult = lottos.countWinningRanks(WinningNumbers(numbers, bonusNumber))
        return LottoWinningStatistics(lottoResult, lottoResult.calculateYield(lottos.size))
    }
}
