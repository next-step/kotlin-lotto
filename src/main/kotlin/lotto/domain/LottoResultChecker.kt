package lotto.domain

object LottoResultChecker {
    fun check(
        userLottos: UserLottos,
        winningLotto: WinningLotto,
    ): LottoResults {
        val matchResults = userLottos.match(winningLotto)
        val ranksAcquiredByUser =
            matchResults.map { matchResult ->
                LottoRank.determineRank(matchResult.matchCount, matchResult.containsBonusNumber)
            }
        return LottoResults(ranksAcquiredByUser)
    }
}
