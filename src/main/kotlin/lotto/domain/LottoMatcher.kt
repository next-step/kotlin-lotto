package lotto.domain

import lotto.domain.Money.EarnedMoney
import lotto.domain.Money.PaidMoney

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

    fun calculateEarnedRate(earnedMoney: EarnedMoney, paidMoney: PaidMoney) =
        EarnedRate(
            earnedMoney.money / paidMoney.money.toFloat()
        )

    private fun formatMatchResult(matchResult: MatchResult) =
        MatchResult(
            Rank.values().associateWith {
                matchResult.matchResult.getOrDefault(it, Count(0))
            }
        )

    private fun getEarnedMoney(matchResult: MatchResult) =
        EarnedMoney(
            matchResult.matchResult
                .map { (rank, count) -> rank.winningMoney * count.count }
                .sum()
        )
}
