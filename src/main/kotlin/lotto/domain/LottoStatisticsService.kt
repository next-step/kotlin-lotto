package lotto.domain

class LottoStatisticsService(
    private val payment: Int,
    private val winLottoList: List<LottoRank>
) {
    fun statistics(): LottoStatisticsTotal {
        val lottoStatistics = LottoStatistics(winLottoList)
        return LottoStatisticsTotal(
            earningRate = lottoStatistics.earningRate(payment),
            winLottoStatisticsResult = lottoStatistics.winLottoStatistics()
        )
    }
}
