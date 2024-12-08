package lotto.domain

class LottoBunch(val value: List<Lotto>) {
    constructor(
        purchaseCount: Int,
        lottoNumberGenerator: LottoNumberGenerator = RandomGenerator,
    ) : this(List(purchaseCount) { Lotto(lottoNumberGenerator) })

    fun getMatchLottoResult(winningNumbers: List<LottoNumber>): Map<MatchingResult, Int> {
        val matchResults = value.mapNotNull { lotto -> lotto.match(winningNumbers) }
        return MatchingResult.getMatchLottoResult(matchResults)
    }

    fun getYield(
        winningNumbers: List<LottoNumber>,
        purchaseAmount: Int,
    ): Double {
        val matchResults: Map<MatchingResult, Int> = getMatchLottoResult(winningNumbers)
        val totalPrize =
            matchResults.entries.fold(0) { acc, (matchingResult, winCount) ->
                acc + (matchingResult.prizeAmount * winCount)
            }
        return totalPrize.toDouble() / purchaseAmount
    }
}
