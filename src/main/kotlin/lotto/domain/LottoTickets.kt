package lotto.domain

class LottoTickets(lottoTickets: List<LottoTicket>) : Collection<LottoTicket> by lottoTickets {
    private val _tickets: List<LottoTicket> = lottoTickets
    val tickets: List<LottoTicket>
        get() = _tickets

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

    companion object {
        private const val LOTTO_TICKET_PRICE = 1000

        fun purchase(amount: Int): LottoTickets {
            require(amount >= LOTTO_TICKET_PRICE) { "구입금액은 1000원 이상이여야 합니다" }
            val quantity = amount / LOTTO_TICKET_PRICE
            val lottoTickets = List(quantity) { LottoTicket.generateLottoNumber() }
            return LottoTickets(lottoTickets)
        }
    }
}
