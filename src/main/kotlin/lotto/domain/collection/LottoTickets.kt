package lotto.domain.collection

import lotto.domain.LottoTicket

data class LottoTickets(
    private val lottoTickets: List<LottoTicket>
) : List<LottoTicket> by lottoTickets {
    init {
        require(lottoTickets.isNotEmpty()) {
            "로또 티켓 개수가 1개 이상이여야 합니다."
        }
    }

    fun getLottoTickets(): List<LottoTicket> {
        return lottoTickets
    }

    fun getMatchCount(matchCount: Int, numbers: Set<Int>): Int {
        return lottoTickets.count() { it.numbers.intersect(numbers).size == matchCount }
    }
}
