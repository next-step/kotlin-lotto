package lotto.domain

object LottoResultService {

    fun inquireStatistics(lottoResultRequest: LottoResultRequest): LottoStatisticsTotal {
        val lottoResults = inquireResult(lottoResultRequest.luckyNumbers, lottoResultRequest.lottoList)
        return LottoStatistics.statistics(lottoResultRequest.payment, lottoResults)
    }

    fun inquireResult(luckyNumbers: List<Int>, lottoList: List<Lotto>): List<LottoResult> {
        return lottoList.map { lotto ->
            val hitCount = lotto.countHitNumbers(luckyNumbers)
            LottoResult(hitCount, calculatePrizeMoney(hitCount))
        }
    }

    private fun calculatePrizeMoney(count: Int) = WinLottoPrize.getPrizeMoney(count)
}
