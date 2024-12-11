package lotto.domain

class LottoTickets(lottoTickets: List<LottoTicket>) : Collection<LottoTicket> by lottoTickets {
    private val _tickets: List<LottoTicket>
    val tickets: List<LottoTicket>
        get() = _tickets

    init {
        require(lottoTickets.isNotEmpty()) { "로또 티켓은 한장 이상 구입해야 합니다" }
        _tickets = lottoTickets
    }

    fun calculateLottoRank(winningLotto: WinningLotto): LottoResults {
        val rankCount =
            tickets
                .map { lotto -> lotto.calculateRank(winningLotto) }
                .groupingBy { it }
                .eachCount()

        val result =
            LottoRank.entries.map { rank ->
                LottoResult(
                    rank,
                    rankCount[rank] ?: 0,
                )
            }
        return LottoResults(result)
    }

    fun count(): Int {
        return tickets.size
    }

    companion object {
        const val LOTTO_TICKET_PRICE = 1000

        fun purchase(amount: Int): LottoTickets {
            val quantity = amount / LOTTO_TICKET_PRICE
            val lottoTickets = ArrayList<LottoTicket>()
            repeat(quantity) {
                lottoTickets.add(LottoTicket.generateLottoNumber())
            }
            return LottoTickets(lottoTickets)
        }
    }
}
