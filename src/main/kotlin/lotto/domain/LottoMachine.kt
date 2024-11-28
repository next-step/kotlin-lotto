package lotto.domain

object LottoMachine {
    fun purchase(tickets: List<Ticket>): List<Lotto> {
        return List(tickets.size) { Lotto.auto() }
    }
}
