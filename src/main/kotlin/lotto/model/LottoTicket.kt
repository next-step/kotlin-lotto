package lotto.model

data class LottoTicket(val lotto: Lotto, private val ticketType: TicketType) {

    infix fun matchedCountBy(target: Lotto): Int {
        return lotto matchedCountBy target
    }

    operator fun contains(number: LottoNumber): Boolean {
        return number in lotto
    }

    companion object {
        val Collection<LottoTicket>.manualSize: Int get() = count { it.ticketType == TicketType.MANUAL }
        val Collection<LottoTicket>.automaticSize: Int get() = count { it.ticketType == TicketType.AUTOMATIC }
    }
}
