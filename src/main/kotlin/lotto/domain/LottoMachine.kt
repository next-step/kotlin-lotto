package lotto.domain

object LottoMachine {
    fun autoPurchase(tickets: List<AutoTicket>): List<Lotto> {
        return List(tickets.size) { Lotto.auto() }
    }

    fun manualPurchase(tickets: List<ManualTicket>): List<Lotto> {
        return tickets.map { Lotto.manual(it.lottoNumbers) }
    }
}
