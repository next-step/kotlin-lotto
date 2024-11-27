package lotto.domain

class LottoBunch(val value: List<Lotto>) {
    fun getMatchLottoResult(winningNumbers: List<LottoNumber>): Map<MatchingResult, Int> {
        val result: MutableMap<MatchingResult, Int> = MatchingResult.entries.associateWith { 0 }.toMutableMap()
        value.forEach {
            val stepResult = it.match(winningNumbers) ?: return@forEach
            result[stepResult] = result.getOrDefault(stepResult, 0) + 1
        }
        return result
    }

    fun getYield(
        winningNumbers: List<LottoNumber>,
        purchaseAmount: Int,
    ): Double {
        val matchResults: Map<MatchingResult, Int> = getMatchLottoResult(winningNumbers)
        var totalPrize = 0
        matchResults.forEach { (matchingResult, winCount) ->
            totalPrize += (matchingResult.prizeAmount * winCount)
        }
        return totalPrize.toDouble() / purchaseAmount
    }
}
