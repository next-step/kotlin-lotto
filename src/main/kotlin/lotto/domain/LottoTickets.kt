package lotto.domain

import lotto.dto.WinStats
import lotto.util.AutoNumbers

class LottoTickets(private val money: Money, autoNumbers: AutoNumbers) {
    val lottoTickets: List<LottoTicket> = List(money.countLotto()) {
        LottoTicket(autoNumbers.generateNumbers())
    }

    fun getWinStats(winNumbers: LottoTicket): WinStats {
        var amount: Long = 0

        val matchMap: Map<WinResult, Int> = lottoTickets.filter {
            it.getWinResult(winNumbers) !== WinResult.LOSE
        }.groupingBy {
            it.getWinResult(winNumbers)
        }.eachCount()

        matchMap.keys.forEach { amount += it.reward }

        return WinStats(matchMap, calculateYield(amount))
    }

    private fun calculateYield(amount: Long): Number {
        if (amount == 0L) {
            return 0
        }
        return amount.toFloat() / money.value
    }
}
