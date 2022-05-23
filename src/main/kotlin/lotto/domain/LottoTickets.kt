package lotto.domain

import lotto.vo.Money

class LottoTickets(val lottoTickets: List<LottoTicket>) {

    fun matching(winningLotto: LottoTicket): LottoRanks {
        val lottoRanks = lottoTickets.map {
            val matchCount = winningLotto.matching(it)
            LottoRank.of(matchCount)
        }
        return LottoRanks(lottoRanks)
    }

    fun amount(): Money {
        return LottoShop.LOTTO_TICKET_PRICE
            .multiply(lottoTickets.size)
    }
}
