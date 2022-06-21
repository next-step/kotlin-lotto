package lotto.domain

class LottoMatcher() {
    fun matchResult(
        lottoTickets: LottoTickets,
        winningNumbers: WinningLotto,
        bonusNumber: BonusNumber
    ): LottoMatchResult {
        val matchResult = formatMatchResult(
            lottoTickets.match(winningNumbers, bonusNumber)
        )
        return LottoMatchResult(matchResult, getEarnedMoney(matchResult))
    }

    fun calculateEarnedRate(earnedMoney: EarnedMoney, paidMoney: Long) =
        EarnedRate(earnedMoney.money / paidMoney.toFloat())

    private fun formatMatchResult(resultMap: Map<Rank, Count>) =
        Rank.values().associateWith { resultMap.getOrDefault(it, Count(0)) }

    private fun getEarnedMoney(matchResult: Map<Rank, Count>) =
        EarnedMoney(
            matchResult
                .map { (rank, count) -> rank.winningMoney * count.count }
                .sum()
        )
}
