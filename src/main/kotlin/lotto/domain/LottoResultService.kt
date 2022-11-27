package lotto.domain

object LottoResultService {

    fun inquireStatistics(lottoResultRequest: LottoResultRequest): LottoStatisticsTotal {
        val lottoWinner = LottoWinner(lottoResultRequest.luckyNumbers)
        val winLottoList = lottoWinner.findWinLottoList(lottoResultRequest.lottoList)
        return LottoStatistics.statistics(lottoResultRequest.payment, winLottoList)
    }
}
