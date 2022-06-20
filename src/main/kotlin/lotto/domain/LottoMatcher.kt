package lotto.domain

class LottoMatcher() {
    fun matchResult(lottoTickets: LottoTickets, winningNumbers: WinningNumber, bonusNumber: BonusNumber): LottoMatchResult {
        val matchResult = formatMatchResult(
            lottoTickets.match(winningNumbers, bonusNumber)
        )
        val earnedMoney = getEarnedMoney(matchResult)
        return LottoMatchResult(matchResult, earnedMoney)
    }

    fun calculateEarnedRate(earnedMoney: EarnedMoney, paidMoney: Long): EarnedRate {
        val earnedRate = earnedMoney.money / paidMoney.toFloat()
        return EarnedRate(earnedRate)
    }

    private fun formatMatchResult(resultMap: Map<Rank, Count>) =
        Rank.values().associateWith { resultMap.getOrDefault(it, Count(0)) }

    private fun getEarnedMoney(matchResult: Map<Rank, Count>): EarnedMoney {
        return EarnedMoney(
            matchResult
                .map { (rank, count) -> rank.winningMoney * count.count }
                .sum()
        )
    }
}
