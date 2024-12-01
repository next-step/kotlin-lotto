package lotto.domain

object LottoMachine {
    fun purchase(tickets: Tickets): List<Lotto> {
        return manualPurchase(tickets.manualTickets) + autoPurchase(tickets.autoTickets)
    }

    private fun manualPurchase(tickets: List<ManualTicket>): List<Lotto> {
        return tickets.map { Lotto.manual(it.lottoNumbers) }
    }

    private fun autoPurchase(tickets: List<AutoTicket>): List<Lotto> {
        return List(tickets.size) { Lotto.auto() }
    }
}
