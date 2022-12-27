package lotto.domain

class LottoResultService(
    private val luckyLotto: Lotto,
    private val bonusNumber: LottoNumber
) {
    fun inquireStatistics(payment: Payment, lottoList: List<Lotto>): LottoStatisticsTotal {
        val winLottoList = findWinLottoList(lottoList)
        val lottoStatisticsService = LottoStatisticsService(payment, winLottoList)
        return lottoStatisticsService.statistics()
    }

    private fun findWinLottoList(lottoList: List<Lotto>): List<LottoRank> {
        return lottoList
            .map { rank(it, bonusNumber) }
            .filter { hasPrize(it) }
    }

    private fun rank(lotto: Lotto, bonusNumber: LottoNumber): LottoRank {
        val hitCount = lotto.countHitNumbers(luckyLotto)
        val hasBonusNumber = lotto.hasBonusNumber(bonusNumber)
        return LottoRank.from(hitCount, hasBonusNumber)
    }

    private fun hasPrize(lottoRank: LottoRank) = lottoRank.prizeMoney > 0
}
