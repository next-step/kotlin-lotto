package lotto.domain

data class LottoWinning(
    val result: Map<TicketResult, Int>,
) {
    fun totalAmount(): Long {
        return result.entries.sumOf {
            WinningAmount.from(it.key.matchCount, it.key.isBonusBallMatched).amount * it.value
        }
    }
}
