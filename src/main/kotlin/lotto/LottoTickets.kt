package lotto

@JvmInline
value class LottoTickets(private val values: List<LottoTicket>) {
    fun size(): Int {
        return this.values.size
    }

    fun matchNumbers(winningNumbers: WinningNumbers): List<LottoMatchResult> {
        return values.map {
            LottoMatchResult(
                matchCount = it.matchNumbers(winningNumbers.numbers),
                isBonusMatch = it.contains(winningNumbers.bonusNumber),
            )
        }
    }

    fun forEach(action: (LottoTicket) -> Unit) {
        this.values.forEach(action)
    }
}
