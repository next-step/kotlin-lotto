package lotto.model.process

import lotto.model.number.LottoNumbers
import lotto.model.price.LottoPrice
import lotto.model.rank.LottoRank
import lotto.model.statistics.DefaultLottoStatistics
import lotto.model.statistics.LottoStatistics

class LottoMachineProcess(
    private val lottoPrice: LottoPrice,
    private val lottoRank: LottoRank,
) : MachineProcess {
    override fun calculateLottoCount(purchaseAmount: Int): Int {
        return lottoPrice.calculateLottoCount(purchaseAmount)
    }

    override fun generateLottoTickets(lottoCount: Int): List<LottoNumbers> {
        return LottoNumbers.issuanceLottoTickets(lottoCount)
    }

    override fun calculateWinningStatistics(
        lottoTickets: List<LottoNumbers>,
        winningNumbers: List<Int>,
        totalPurchaseAmount: Int,
    ): LottoStatistics {
        val winningRank =
            lottoRank.calculateWinningCounts(
                lottoTickets,
                winningNumbers,
            )
        return DefaultLottoStatistics(winningRank, totalPurchaseAmount)
    }
}
