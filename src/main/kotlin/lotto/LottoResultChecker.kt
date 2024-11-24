package lotto

class LottoResultChecker {
    fun check(
        lottos: List<Lotto>,
        winningNumbers: WinningNumbers,
    ): LottoResults {
        val matchCounts =
            lottos.map { lotto ->
                lotto.calculateMatchCount(winningNumbers)
            }

        val ranks =
            matchCounts.filter { matchCount -> LottoRank.isInTheRank(matchCount) }
                .map { matchCount -> LottoRank.from(matchCount) }

        return LottoResults(ranks)
    }
}
