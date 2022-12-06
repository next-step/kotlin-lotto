package lotto.domain

class LottoResultService(
    luckyNumbers: LuckyNumbers,
) {
    private val lottoWinner = LottoWinner(luckyNumbers)

    fun inquireStatistics(payment: Int, lottoList: List<Lotto>): LottoStatisticsTotal {
        val winLottoList = lottoWinner.findWinLottoList(lottoList)
        val lottoStatisticsService = LottoStatisticsService(payment, winLottoList)
        return lottoStatisticsService.statistics()
    }
}
