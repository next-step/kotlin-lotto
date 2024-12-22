package lotto.model.process

import lotto.model.number.LottoNumbers
import lotto.model.statistics.LottoStatistics

interface MachineProcess {
    fun calculateLottoCount(purchaseAmount: Int): Int

    fun generateLottoTickets(lottoCount: Int): List<LottoNumbers>

    fun calculateWinningStatistics(
        lottoTickets: List<LottoNumbers>,
        winningNumbers: List<Int>,
        totalPurchaseAmount: Int,
    ): LottoStatistics
}
