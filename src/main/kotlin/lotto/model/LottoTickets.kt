package lotto.model

class LottoTickets(private val lottoTickets: List<LottoTicket>) : List<LottoTicket> by lottoTickets {

    constructor(vararg lottoTickets: LottoTicket) : this(lottoTickets.toList())

    operator fun plus(other: LottoTickets): LottoTickets {
        return LottoTickets(lottoTickets + other.lottoTickets)
    }

    companion object {
        fun issue(ticketCount: Int, generator: NumbersGenerator): LottoTickets {
            return LottoTickets((1..ticketCount).map { LottoTicket(generator) })
        }
    }
}
