package lotto.domain

object LottoResultChecker {
    fun check(
        userLottos: UserLottos,
        winningLotto: WinningLotto,
        bonusNumber: LottoNumber
    ): LottoResults {
        val matchResults = userLottos.match(winningLotto, bonusNumber)
        val ranksAcquiredByUser = matchResults.map { matchResult -> LottoRank.determineRank(matchResult.matchCount, matchResult.containsBonusNumber) }
        return LottoResults(ranksAcquiredByUser)
    }
}

