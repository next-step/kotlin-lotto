package lotto.domain

import lotto.dto.WinStats
import lotto.util.AutoNumbers

class LottoTickets(private val money: Money, autoNumbers: AutoNumbers) {
    val lottoTickets: List<LottoTicket> = List(money.countLotto()) {
        LottoTicket(autoNumbers.generateNumbers())
    }

    fun getWinStats(winNumbers: LottoTicket): WinStats {
        val matchMap: MutableMap<WinResult, Int> = mutableMapOf()
        var amount: Long = 0

        lottoTickets.filter {
            it.getWinResult(winNumbers) !== WinResult.LOSE
        }.map {
            val winResult: WinResult = it.getWinResult(winNumbers)
            matchMap[winResult] = matchMap.getOrDefault(winResult, 0) + 1
            amount += winResult.reward
        }
        return WinStats(matchMap, calculateYield(amount))
    }

    private fun calculateYield(amount: Long): Number {
        if (amount == 0L) {
            return 0
        }
        return amount.toFloat() / money.value
    }
}
