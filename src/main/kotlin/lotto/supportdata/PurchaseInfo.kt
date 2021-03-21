package lotto.supportdata

import lotto.domain.LottoTicket

data class PurchaseInfo(val moneyInput: Int, private val manualTicketInput: List<String> = emptyList()) {
    private val totalTicketNumber: Int = moneyInput / BASE_MONEY
    val manualTicketNumber: Int = manualTicketInput.size
    val autoTicketNumber: Int = totalTicketNumber - manualTicketNumber
    val manualTicket: List<LottoTicket> = manualTicketInput.map { parseInputToLotto(it) }

    companion object {
        const val BASE_MONEY = 1000
    }
}
