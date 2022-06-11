package lotto

@JvmInline
value class LottoTickets(val values: List<LottoTicket>) {
    fun size(): Int {
        return this.values.size
    }

    fun matchNumbers(target: LottoTicket): List<Int> {
        return values.map { it.matchNumbers(target) }
    }

    fun forEach(action: (LottoTicket) -> Unit) {
        this.values.forEach(action)
    }
}
