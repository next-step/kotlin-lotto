package lotto.domain

class LottoShop {
    private val lottoTicketGenerator = LottoTicketGenerator()

    fun purchase(amount: Int): List<LottoTicket> {
        val count = calculateCount(amount)
        return List(count) { lottoTicketGenerator.create() }
    }

    fun receivePrize(tickets: List<LottoTicket>, winningTicket: WinningLottoTicket): LottoResult {
        return LottoResult.of(LottoTickets(tickets), winningTicket, TICKET_PRICE)
    }

    private fun calculateCount(amount: Int): Int {
        return amount / TICKET_PRICE
    }

    companion object {
        const val TICKET_PRICE = 1_000
    }
}