package lotto.domain

import lotto.utils.LottoNumberGenerator

class LottoMachine {

    fun ticketing(amount: Int): List<LottoTicket> {
        require(amount > 0) {
            "구입금액은 0이하일 수 없어요."
        }

        val ticketAmount = getTicketAmount(amount)

        val ticketBundle = mutableListOf<LottoTicket>()
        repeat(ticketAmount) {
            val numbers = LottoNumberGenerator.auto()
            ticketBundle.add(
                element = LottoTicket(numbers)
            )
        }

        return ticketBundle
    }

    fun getTicketAmount(amount: Int): Int {
        return amount / LOTTO_TICKET_AMOUNT
    }

    companion object {
        private const val LOTTO_TICKET_AMOUNT = 1000
    }
}
