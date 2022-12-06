package lotto.domain

class LottoTickets(
    val items: List<LottoTicket>
) {
    fun count(): Int = items.size

    operator fun plus(target: LottoTickets): LottoTickets {
        return LottoTickets(items + target.items)
    }
}
