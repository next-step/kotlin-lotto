package lotto.domain

class Lottos(val tickets: List<LottoTicket>) {
    companion object {
        fun of(amount: Int): Lottos {
            val tickets = mutableListOf<LottoTicket>()
            repeat(amount) {
                tickets.add(LottoTicket(LottoNumber()))
            }

            return Lottos(tickets)
        }
    }
}
