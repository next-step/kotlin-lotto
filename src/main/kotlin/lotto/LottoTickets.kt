package lotto

class LottoTickets(lottoTickets: List<LottoTicket>) : Iterable<LottoTicket> {
    private val _tickets: List<LottoTicket>
    val tickets: List<LottoTicket>
        get() = _tickets

    init {
        require(lottoTickets.isNotEmpty()) { "로또 티켓은 한장 이상 구입해야 합니다" }
        _tickets = lottoTickets
    }

    override fun iterator(): Iterator<LottoTicket> {
        return _tickets.iterator()
    }

    companion object {
        fun purchase(amount: Int): LottoTickets {
            val quantity = amount / 1000
            val lottoTickets = ArrayList<LottoTicket>()
            repeat(quantity) {
                lottoTickets.add(LottoTicket.generateLottoNumber())
            }
            return LottoTickets(lottoTickets)
        }
    }
}
