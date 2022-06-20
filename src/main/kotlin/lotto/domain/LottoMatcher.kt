package lotto.domain

class LottoMatcher() {
    fun matchResult(lottoTickets: LottoTickets, winningNumbers: WinningNumber): LottoMatchResult {
        val matchedResult = getMatchResult(lottoTickets, winningNumbers)
        val earnedMoney = getEarnedMoney(matchedResult)
        return LottoMatchResult(matchedResult, earnedMoney)
    }

    private fun getMatchResult(lottoTickets: LottoTickets, winningNumbers: WinningNumber): Map<Rank, Int> {
        return generateMatchResult(lottoTickets.match(winningNumbers))
    }

    fun calculateEarnedRate(earnedMoney: EarnedMoney, paidMoney: Long): EarnedRate {
        val earnedRate = earnedMoney.money / paidMoney.toFloat()
        return EarnedRate(earnedRate)
    }

    private fun generateMatchResult(rankCountMap: Map<Rank, Int>): Map<Rank, Int> {
        return Rank.values().associateWith { rankCountMap.getOrDefault(it, 0) }
    }

    private fun getEarnedMoney(matchedResult: Map<Rank, Int>): EarnedMoney {
        val earnedMoney = matchedResult
            .map { (winningInfo, winningCount) -> winningInfo.winningMoney * winningCount }
            .sum()
        return EarnedMoney(earnedMoney)
    }
}
