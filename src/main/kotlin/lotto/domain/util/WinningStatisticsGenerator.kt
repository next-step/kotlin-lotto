package lotto.domain.util

import lotto.domain.LotteryTickets
import lotto.domain.LottoRanking
import lotto.domain.LottoStore
import lotto.domain.WinningLottoNumber
import java.math.BigDecimal
import java.math.RoundingMode

object WinningStatisticsGenerator {

    fun getRankingCountStatistics(lotteryTickets: LotteryTickets, winningLottoNumber: WinningLottoNumber): Map<LottoRanking, Int> =
        lotteryTickets.groupingBy { winningLottoNumber.getRanking(it.lottoNumbers) }.eachCount()

    fun getRevenueRateStatistics(lotteryTickets: LotteryTickets, winningLottoNumber: WinningLottoNumber): BigDecimal {
        val totalWinningAmount = lotteryTickets.sumOf { winningLottoNumber.getRanking(it.lottoNumbers).winningAmount }
        val totalPurchaseAmount = BigDecimal(lotteryTickets.size * LottoStore.PURCHASE_AMOUNT_UNIT)
        return BigDecimal(totalWinningAmount).divide(totalPurchaseAmount, 2, RoundingMode.DOWN)
    }
}
