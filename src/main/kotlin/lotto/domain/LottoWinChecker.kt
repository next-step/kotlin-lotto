package lotto.domain

class LottoWinChecker(private val lottos: List<Lotto>) {

    fun getPrizes(winningNumbers: List<LottoNumber>, bonusNumber: LottoNumber): List<LottoPrize> {
        return lottos
            .mapNotNull {
                val matchCount = it.countMatches(winningNumbers)
                val bonusMatch = it.checkBonusMatch(bonusNumber)
                LottoPrize.fromMatchCount(matchCount, bonusMatch)
            }
            .sortedBy { it.matchCount }
    }
}
