package lotto.domain

import lotto.domain.LottoTicket

interface LottoTicketGenerateStrategy {

    fun createAutoTicket(): LottoTicket

    fun createManualTicket(numbers: List<Int>): LottoTicket
}
