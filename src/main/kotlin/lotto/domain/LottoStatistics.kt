package lotto.domain

object LottoStatistics {

    fun statistics(inputPayment: Int, winLottoList: List<WinLottoPrize>): LottoStatisticsTotal {
        val winLottoStatisticsResult = winLottoStatistics(winLottoList)
        val lottoReward = LottoReward(winLottoList)
        return LottoStatisticsTotal(
            earningRate = lottoReward.earningRate(inputPayment),
            winLottoStatisticsResult = winLottoStatisticsResult
        )
    }

    private fun winLottoStatistics(winLottoList: List<WinLottoPrize>): List<LottoStatisticsResult> {
        val hitCountMap = winLottoList.groupBy { winLottoPrize: WinLottoPrize -> winLottoPrize.hitCount }

        return WinLottoPrize.values().map {
            LottoStatisticsResult(
                winLottoPrize = it,
                winLottoCount = hitCountMap.getOrDefault(it.hitCount, emptyList()).size
            )
        }
    }
}
