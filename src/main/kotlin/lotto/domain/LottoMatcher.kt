package lotto.domain

import lotto.constant.WinningInfo

@JvmInline value class EarnedRate(val rate: String)
@JvmInline value class EarnedMoney(val money: Long)

data class LottoMatchResult(
    val matchResult: Map<WinningInfo, Int>,
)

class LottoMatcher() {
    fun matchResult(lottoTickets: LottoTickets, winningNumbers: WinningNumber): LottoMatchResult {
        val mapMatchCount = lottoTickets.match(winningNumbers)
        val mapMatchResult = generateMatchResult(mapMatchCount)
        return LottoMatchResult(mapMatchResult)
    }

    fun getEarnedMoney(matchResult: LottoMatchResult): EarnedMoney {
        val earnedMoney = matchResult.matchResult
            .map { (winningInfo, winningCount) -> winningInfo.winningMoney * winningCount }
            .sum()
        return EarnedMoney(earnedMoney)
    }

    fun getEarnedRate(paidMoney: Int, earnedMoney: EarnedMoney): EarnedRate {
        val earnedRate = String.format("%.3f", earnedMoney.money / paidMoney.toFloat()).dropLast(1)
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
