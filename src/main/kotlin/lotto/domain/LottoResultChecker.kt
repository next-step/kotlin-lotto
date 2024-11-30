package lotto.domain

object LottoResultChecker {
    fun check(
        lottos: Lottos,
        winningNumbers: WinningNumbers,
    ): LottoResults {
        val matchCounts = lottos.calculateAllMatchCounts(winningNumbers)

        val ranks =
            matchCounts.filter { matchCount -> LottoRank.isInTheRank(matchCount) }
                .map { matchCount -> LottoRank.from(matchCount) }

        return LottoResults(ranks)
    }
}
