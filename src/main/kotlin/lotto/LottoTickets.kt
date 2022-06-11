package lotto

@JvmInline
value class LottoTickets(private val values: List<LottoTicket>) {
    fun size(): Int {
        return this.values.size
    }
}
