package lotto.domain

import lotto.common.LottoTicketPolicy

object LottoMachine {
    fun calculateTicketCount(amount: Int, manualTicketCount: Int): LottoTicketCount {
        val autoTicketCount = (amount / LottoTicketPolicy.PRICE) - manualTicketCount

        return LottoTicketCount(autoTicketCount, manualTicketCount)
    }
}
