package lotto.domain

import lotto.utils.LottoNumberGenerator
import lotto.view.ResultView

class LottoMachine {

    fun ticketing(amount: Int): List<LottoTicket> {
        require(amount > 0) {
            "구입금액은 0이하일 수 없어요."
        }

        val ticketAmount = getTicketAmount(amount)
        ResultView.printTicketAmount(ticketAmount)

        val ticketBundle = buildList(ticketAmount) {
            repeat(ticketAmount) {
                val numbers = LottoNumberGenerator.auto()
                add(LottoTicket(numbers))
            }
        }

        return ticketBundle
    }

    private fun getTicketAmount(amount: Int): Int {
        return amount / LOTTO_TICKET_AMOUNT
    }

    companion object {
        private const val LOTTO_TICKET_AMOUNT = 1000
    }
}
