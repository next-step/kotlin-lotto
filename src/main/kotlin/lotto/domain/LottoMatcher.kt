package lotto.domain

@JvmInline value class EarnedRate(val rate: Float)
@JvmInline value class EarnedMoney(val money: Long)

data class LottoMatchResult(
    val matchResult: Map<WinningInfo, Int>,
    val earnedMoney: EarnedMoney,
)

class LottoMatcher() {
    fun matchResult(lottoTickets: LottoTickets, winningNumbers: WinningNumber): LottoMatchResult {
        val matchedResult = getMatchedResult(lottoTickets, winningNumbers)
        val earnedMoney = getEarnedMoney(matchedResult)
        return LottoMatchResult(matchedResult, earnedMoney)
    }

    fun calculateEarnedRate(earnedMoney: EarnedMoney, paidMoney: Int): EarnedRate {
        val earnedRate = earnedMoney.money.toFloat() / paidMoney
        return EarnedRate(earnedRate)
    }

    private fun getMatchedResult(lottoTickets: LottoTickets, winningNumbers: WinningNumber): Map<WinningInfo, Int> {
        return generateMatchResult(lottoTickets.match(winningNumbers))
    }

    private fun generateMatchResult(winningCountMap: Map<WinningInfo, Int>): Map<WinningInfo, Int> {
        return WinningInfo.values().associateWith { winningInfo -> winningCountMap.getOrDefault(winningInfo, 0) }
    }

    private fun getEarnedMoney(matchedResult: Map<WinningInfo, Int>): EarnedMoney {
        val earnedMoney = matchedResult
            .map { (winningInfo, winningCount) -> winningInfo.winningMoney * winningCount }
            .sum()
        return EarnedMoney(earnedMoney)
    }
}
