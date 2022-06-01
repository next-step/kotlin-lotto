package camp.nextstep.lotto.user

import camp.nextstep.lotto.ticket.LottoStore
import camp.nextstep.lotto.ticket.LottoTicket

class Gambler(var balance: Int = 0) {

    val tickets = mutableListOf<LottoTicket>()

    fun exchangeAll(store: LottoStore) {
        val (tickets, balance) = store.exchangeAll(balance)
        this.tickets.addAll(tickets)
        this.balance = balance
    }

    fun exchange(store: LottoStore, gamblerNumbers: List<List<Int>>) {
        val (tickets, balance) = store.exchange(balance, gamblerNumbers)
        this.tickets.addAll(tickets)
        this.balance = balance
    }
}
