package lotto.domain

class LottoBunch(val value: List<Lotto>) {
    constructor(
        purchaseCount: Int,
        lottoNumberGenerator: LottoNumberGenerator = RandomGenerator,
    ) : this(List(purchaseCount) { Lotto(lottoNumberGenerator) })

    fun getMatchLottoResult(
        winningNumbers: List<LottoNumber>,
        bonusNumber: LottoNumber,
    ): Map<MatchingResult, Int> {
        val matchResults = value.mapNotNull { lotto -> lotto.match(winningNumbers, bonusNumber) }
        return MatchingResult.getMatchLottoResult(matchResults)
    }

    fun getYield(
        winningNumbers: List<LottoNumber>,
        bonusNumber: LottoNumber,
        purchaseAmount: Int,
    ): Double {
        val matchResults: Map<MatchingResult, Int> = getMatchLottoResult(winningNumbers, bonusNumber)
        val totalPrize =
            matchResults.entries.fold(0) { acc, (matchingResult, winCount) ->
                acc + (matchingResult.prizeAmount * winCount)
            }
        return totalPrize.toDouble() / purchaseAmount
    }
}
