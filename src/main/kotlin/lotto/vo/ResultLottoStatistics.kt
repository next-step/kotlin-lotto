package lotto.vo

import lotto.domain.LottoProfitRate
import lotto.domain.WinningLottoStatistics

class ResultLottoStatistics(
    val winningLottoStatistics: WinningLottoStatistics,
    val profitRate: LottoProfitRate
)
