package lotto.view.monitor

import lotto.model.number.LottoNumbers
import lotto.model.statistics.LottoStatistics

interface Monitor {
    fun displayLottoPurchaseAmount()

    fun displayLottoPurchasesCount(count: Int)

    fun displayInputLastWeekLottoWinningNumbers()

    fun displayIssuedLottoTickets(lottoTickets: List<LottoNumbers>)

    fun displayLottoStatistics(statistics: LottoStatistics)
}
