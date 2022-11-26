package lotto.domain

object LottoResultService {

    fun inquireStatistics(lottoResultRequest: LottoResultRequest): LottoStatisticsTotal {
        val winLottoList = LottoWinner.findWinLottoList(lottoResultRequest.luckyNumbers, lottoResultRequest.lottoList)
        return LottoStatistics.statistics(lottoResultRequest.payment, winLottoList)
    }
}
