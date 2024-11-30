package lotto.domain

object LottoResultChecker {
    fun check(
        userLottos: UserLottos,
        winningLotto: WinningLotto,
    ): LottoResults {
        val matchCounts = userLottos.calculateMatchCountEach(winningLotto)

        val ranks =
            matchCounts.filter { matchCount -> LottoRank.isInTheRank(matchCount) }
                .map { matchCount -> LottoRank.from(matchCount) }

        return LottoResults(ranks)
    }
}
