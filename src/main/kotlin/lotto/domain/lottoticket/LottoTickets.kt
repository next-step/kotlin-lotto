package lotto.domain.lottoticket

import lotto.domain.WinningAmount
import lotto.domain.WinningResult
import lotto.domain.WinningTicket

class LottoTickets constructor(
    val values: List<LottoTicket>,
) {
    fun totalMatchResults(winningTicket: WinningTicket): WinningResult {
        val winningAmountMap = WinningAmount.values()
            .associateWith { 0 }
            .toMutableMap()

        values.forEach {
            val winningAmount = winningTicket.matchResult(it)
            winningAmountMap.computeIfPresent(winningAmount) { _, amount -> amount.inc() }
        }

        return WinningResult(winningAmountMap)
    }
}
