package lotto.model

class LottoTickets private constructor(private val lottoTickets: Set<LottoTicket>) : Set<LottoTicket> by lottoTickets {

    constructor(vararg lottoTickets: LottoTicket) : this(lottoTickets.toSet())

    constructor(lottoTickets: List<LottoTicket>) : this(lottoTickets.toSet())

    operator fun plus(other: LottoTickets): LottoTickets {
        return LottoTickets(lottoTickets + other.lottoTickets)
    }
}
