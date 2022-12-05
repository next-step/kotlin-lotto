package lotto.domain

class LottoTickets(
    val items: List<LottoTicket>
) {
    fun count(): Int = items.size

    fun addAll(target: LottoTickets): LottoTickets {
        return LottoTickets(items.plus(target.items))
    }
}
