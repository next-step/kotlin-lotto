package lotto.domain

import lotto.domain.lottoticket.LottoNumber
import lotto.domain.lottoticket.LottoNumbers
import lotto.domain.lottoticket.LottoTicket
import lotto.domain.lottoticket.LottoTickets

class LottoTicketSeller {
    fun buyLottoTickets(money: Money): LottoTickets {
        val lottoTickets = mutableListOf<LottoTicket>()
        repeat(money.divideInt(LottoTicket.PRICE)) { lottoTickets.add(issueLottoTicket()) }
        return LottoTickets(values = lottoTickets)
    }

    private fun issueLottoTicket(): LottoTicket {
        val lottoNumbers = LottoNumber.cachedLottoNumbers()
            .asSequence()
            .shuffled()
            .take(LottoNumbers.NUMBERS_COUNT)
            .toSet()

        return LottoTicket(lottoNumbers = LottoNumbers.createWithSort(lottoNumbers))
    }
}
