package lotto.domain

import lotto.TicketResult

data class LottoWinning(
    val result: Map<TicketResult, Int>,
) {
    fun totalAmount(): Long {
        var totalAmount = 0L
        result.entries.map {
            totalAmount += WinningAmount.from(it.key.matchCount, it.key.isBonusBallMatched).amount * it.value
        }

        return totalAmount
    }
}
