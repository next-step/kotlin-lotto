package lotto.domain

object LottoResultChecker {
    fun check(
        userLottos: UserLottos,
        winningLotto: WinningLotto,
    ): LottoResults {
        val matchCounts = userLottos.calculateMatchCountEach(winningLotto)
        val containsBonusNumber = true  // fixme

        val ranksAcquiredByUser = matchCounts.map { matchCount -> LottoRank.determineRank(matchCount, containsBonusNumber) }
        return LottoResults(ranksAcquiredByUser)
    }
}

