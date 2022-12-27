package lotto.domain

data class LottoWinningResult(
    val result: Map<LottoTicketResult, Int>,
) {
    fun totalAmount(): Long {
        return result.entries.sumOf {
            WinningAmount.from(it.key.matchCount, it.key.isBonusBallMatched).amount * it.value
        }
    }
}
