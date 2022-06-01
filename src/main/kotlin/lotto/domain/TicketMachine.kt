package lotto.domain

import lotto.domain.LottoTicket.Companion.NUMBER_SIZE

class TicketMachine(private val numberGenerator: NumberGenerator) {

    fun buy(amount: Int): List<LottoTicket> {
        val count = amount / TICKET_PRICE
        require(count > 0) { "1개 이상 구매할 수 있습니다." }
        return List(count) { LottoTicket(numberGenerator.randomTake(NUMBER_SIZE)) }
    }

    companion object {
        private const val TICKET_PRICE = 1_000
    }
}
