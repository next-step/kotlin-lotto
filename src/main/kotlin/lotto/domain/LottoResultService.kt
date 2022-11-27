package lotto.domain

class LottoResultService(
    private val luckyNumbers: List<Int>
) {
    fun inquireStatistics(payment: Int, lottoList: List<Lotto>): LottoStatisticsTotal {
        val lottoWinner = LottoWinner(luckyNumbers)
        val winLottoList = lottoWinner.findWinLottoList(lottoList)
        return LottoStatistics.statistics(payment, winLottoList)
    }
}
