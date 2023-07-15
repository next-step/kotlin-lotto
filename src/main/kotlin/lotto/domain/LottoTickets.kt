package lotto.domain

import lotto.dto.WinStats

class LottoTickets(private val money: Money, val lottoTickets: List<LottoTicket>) {

    fun getWinStats(winNumbers: LottoTicket, bonus: Int): WinStats {
        val matchMap: Map<WinResult, Int> = lottoTickets.map {
            it.getWinResult(winNumbers, bonus)
        }.filter {
            it !== WinResult.LOSE
        }.groupingBy { it }
            .eachCount()

        val amount = matchMap.keys
            .map { it.reward }
            .fold(0.0f) { total, num -> total + num }

        return WinStats(matchMap, calculateYield(amount))
    }

    private fun calculateYield(amount: Float): Number {
        if (amount == 0.0f) {
            return 0
        }
        return amount / money.value
    }
}
