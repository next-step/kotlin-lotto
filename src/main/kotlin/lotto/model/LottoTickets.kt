package lotto.model

class LottoTickets private constructor(private val lottoTickets: Set<LottoTicket>) : Set<LottoTicket> by lottoTickets {

    constructor(vararg lottoTickets: LottoTicket) : this(lottoTickets.toSet())

    constructor(lottoTickets: List<LottoTicket>) : this(lottoTickets.toSet())

    operator fun plus(other: LottoTickets): LottoTickets {
        return LottoTickets(lottoTickets + other.lottoTickets)
    }

    companion object {
        fun issue(ticketCount: Int, generator: NumbersGenerator): LottoTickets {
            return LottoTickets((1..ticketCount).map { LottoTicket(generator) })
        }
    }
}
