package lotto.domain

import lotto.vo.Money

class LottoTickets(val lottoTickets: List<LottoTicket>) {

    fun matching(winningLotto: WinningLotto): LottoRanks {
        return LottoRanks(lottoTickets.map(winningLotto::matching))
    }

    fun amount(): Money {
        return LottoShop.LOTTO_TICKET_PRICE
            .multiply(lottoTickets.size)
    }
}
