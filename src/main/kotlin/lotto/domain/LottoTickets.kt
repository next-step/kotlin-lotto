package lotto.domain

class LottoTickets(private val lottoTickets: List<LottoTicket>) : Collection<LottoTicket> by lottoTickets {
    fun calculateLottoRank(winningLotto: LottoTicket): LottoResults {
        val rankCount =
            lottoTickets
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

    fun calculateLottoRank2(winningLotto: WinningLotto): LottoResults {
        val rankCount =
            lottoTickets
                .map { lotto -> lotto.calculateRank2(winningLotto) }
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
            require(amount >= LOTTO_TICKET_PRICE) { "구입금액은 ${LOTTO_TICKET_PRICE}원 이상이여야 합니다" }
            val quantity = amount / LOTTO_TICKET_PRICE
            val lottoTickets = List(quantity) { LottoTicket.generateLottoNumber() }
            return LottoTickets(lottoTickets)
        }
    }
}
