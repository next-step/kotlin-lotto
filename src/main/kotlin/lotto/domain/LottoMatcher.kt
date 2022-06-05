package lotto.domain

import lotto.constant.WinningInfo

data class LottoMatchResult(
    val matchResult: Map<WinningInfo, Int>,
)

inline class EarnedRate(val earnedRate: String)

class LottoMatcher() {
    fun matchResult(lottoTickets: LottoTickets, winningNumbers: WinningNumber): LottoMatchResult {
        val mapMatchCount = lottoTickets.match(winningNumbers)
        val mapMatchResult = generateMatchResult(mapMatchCount)
        return LottoMatchResult(mapMatchResult)
    }

    fun getEarnedRate(paidMoney: Int, matchResult: LottoMatchResult): EarnedRate {
        val earnedMoney = matchResult.matchResult
            .map { (winningInfo, winningCount) -> winningInfo.winningMoney * winningCount }
            .sum()
        val earnedRate = String.format("%.3f", earnedMoney / paidMoney.toFloat()).dropLast(1)
        return EarnedRate(earnedRate)
    }

    private fun generateMatchResult(mapMatchCount: Map<WinningInfo, Int>): Map<WinningInfo, Int> {
        val matchResult = mutableMapOf<WinningInfo, Int>()
        WinningInfo.values().map { winningInfo ->
            matchResult.put(winningInfo, mapMatchCount.getOrDefault(winningInfo, 0))
        }
        return matchResult
    }
}
