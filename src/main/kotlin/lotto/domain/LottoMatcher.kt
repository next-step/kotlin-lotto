package lotto.domain

class LottoMatcher() {
    fun matchResult(lottoTickets: LottoTickets, winningNumbers: WinningNumber): LottoMatchResult {
        val matchedResult = getMatchResult(lottoTickets, winningNumbers)
        val earnedMoney = getEarnedMoney(matchedResult)
        return LottoMatchResult(matchedResult, earnedMoney)
    }

    fun calculateEarnedRate(earnedMoney: EarnedMoney, paidMoney: Long): EarnedRate {
        val earnedRate = earnedMoney.money / paidMoney.toFloat()
        return EarnedRate(earnedRate)
    }

    private fun getMatchResult(lottoTickets: LottoTickets, winningNumbers: WinningNumber): Map<WinningInfo, Int> {
        return generateMatchResult(lottoTickets.match(winningNumbers))
    }

    private fun generateMatchResult(winningCountMap: Map<WinningInfo, Int>): Map<WinningInfo, Int> {
        return WinningInfo.values().associateWith { winningCountMap.getOrDefault(it, 0) }
    }

    private fun getEarnedMoney(matchedResult: Map<WinningInfo, Int>): EarnedMoney {
        val earnedMoney = matchedResult
            .map { (winningInfo, winningCount) -> winningInfo.winningMoney * winningCount }
            .sum()
        return EarnedMoney(earnedMoney)
    }
}
