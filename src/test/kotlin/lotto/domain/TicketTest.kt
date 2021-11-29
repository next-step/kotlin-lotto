package lotto.domain

import lotto.domain.Ticket.Companion.MAX_NUMBER
import lotto.domain.Ticket.Companion.NUMBER_COUNT
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TicketTest {

    private val ticketGenerator = TicketGenerator(NumberStrategyImpl(NumberStrategy.NUMBERS))

    @Test
    fun `티켓 생성시 올바른 티켓 번호 검증`() {
        val ticket = ticketGenerator.tickets(1000).first()
        assertTrue(ticket.numbers.none { it > MAX_NUMBER })
        assertTrue(ticket.numbers.size == NUMBER_COUNT)
    }

    @Test
    fun `rank 판단 검증`() {
        val ticket = ticketGenerator.tickets(1000).first()
        val rank = ticket.getRank(ticket.numbers)
        assertEquals(Rank.FIRST, rank)
    }

}
