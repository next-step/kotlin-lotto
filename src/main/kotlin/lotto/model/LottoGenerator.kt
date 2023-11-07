package lotto.model

import lotto.collection.LottoNumber
import lotto.collection.LottoTicket

object LottoGenerator {
    private fun getLottoNumbers (range: IntRange) = (range).shuffled().take(LottoTicket.NUMBER_COUNT).map { LottoNumber(it) }

    fun generateTickets(ticketCount: Int) = List(ticketCount) {
        LottoTicket(getLottoNumbers(LottoNumber.NUMBER_RANGE))
    }
}
