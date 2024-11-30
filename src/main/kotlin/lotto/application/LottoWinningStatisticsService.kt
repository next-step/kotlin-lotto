package lotto.application

import lotto.core.LottoNumber
import lotto.core.LottoResult
import lotto.core.Lottos
import lotto.core.WinningLotto

object LottoWinningStatisticsService {
    fun start(
        lottos: Lottos,
        numbers: List<LottoNumber>,
        bonusNumber: LottoNumber,
    ): LottoResult {
        return lottos.countWinningRanks(WinningLotto(numbers, bonusNumber))
    }
}
