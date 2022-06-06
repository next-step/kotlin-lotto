package lotto.domain

import lotto.domain.`interface`.LottoRandomNumbers

class Lottos(val tickets: List<LottoTicket>) {
    companion object {
        fun of(amount: Int): Lottos {
            val tickets = mutableListOf<LottoTicket>()
            repeat(amount) {
                tickets.add(LottoTicket(LottoRandomNumbers().createNumbers()))
            }

            return Lottos(tickets)
        }
    }
}
