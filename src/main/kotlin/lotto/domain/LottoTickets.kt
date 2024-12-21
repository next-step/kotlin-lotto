package lotto.domain

class LottoTickets(private val lottoTickets: List<LottoTicket>) : Collection<LottoTicket> by lottoTickets {
    fun calculateLottoRank(winningLotto: WinningLotto): LottoResults {
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

    companion object {
        const val LOTTO_TICKET_PRICE = 1000

        fun purchase(amount: Int): LottoTickets {
            require(amount >= LOTTO_TICKET_PRICE) { "구입금액은 ${LOTTO_TICKET_PRICE}원 이상이여야 합니다" }
            val quantity = amount / LOTTO_TICKET_PRICE
            val lottoTickets = List(quantity) { LottoTicket.generateLottoNumber() }
            return LottoTickets(lottoTickets)
        }

        fun generateAutoLottoTickets(autoLottoQuantity: Int): LottoTickets {
            if (autoLottoQuantity > 0) {
                val lottoTickets = List(autoLottoQuantity) { LottoTicket.generateLottoNumber() }
                return LottoTickets(lottoTickets)
            }
            return LottoTickets(listOf())
        }
    }
}
