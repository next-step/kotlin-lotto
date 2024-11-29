package lotto.domain

class LottoResult(
    lottos: List<Lotto>,
    winnerNumbers: List<Int>,
) {
    val prizeCounts: Map<LottoPrize, Int> = generateLottoResult(lottos, winnerNumbers)

    private fun generateLottoResult(
        lottoNumbers: List<Lotto>,
        winnerNumbers: List<Int>,
    ): Map<LottoPrize, Int> {
        val prizeCountsMap =
            lottoNumbers
                .groupBy { LottoChecker.findMatchingNumbers(it.lottoNumbers, winnerNumbers) }

        return LottoPrize.entries.associateWith { prize ->
            prizeCountsMap[prize.matchCount]?.size ?: 0
        }
    }
}
