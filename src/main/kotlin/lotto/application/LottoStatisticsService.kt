package lotto.application

import lotto.domain.Lotto
import lotto.domain.LottoPrize
import lotto.domain.LottoStatisticsResult
import lotto.domain.LottoStatisticsTotal
import lotto.domain.LottoWinner
import lotto.domain.Reward

class LottoStatisticsService {

    fun statistics(luckNumberList: List<Int>, lottoList: List<Lotto>, inputPayment: Int): LottoStatisticsTotal {
        val winLottoList = LottoWinner(luckNumberList, lottoList).findWinLottoList()

        val winLottoStatisticsResult = winLottoStatistics(winLottoList)
        val lottoPrize = LottoPrize(winLottoList.map { it.prizeMoney })
        return LottoStatisticsTotal(
            totalRate = lottoPrize.totalRate(inputPayment),
            winLottoStatisticsResult = winLottoStatisticsResult
        )
    }

    private fun winLottoStatistics(winLottoList: List<Reward>): List<LottoStatisticsResult> {
        val hitCountMap = winLottoList.groupBy { winLottoPrize: Reward -> winLottoPrize.hitCount }

        return Reward.values().map {
            LottoStatisticsResult(
                winLottoPrize = it,
                winLottoCount = hitCountMap.getOrDefault(it.hitCount, emptyList()).size
            )
        }
    }
}
