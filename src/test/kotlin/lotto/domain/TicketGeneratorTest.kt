package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TicketGeneratorTest {

    private val ticketGenerator = TicketGenerator(RandomNumberStrategy)

    @Test
    fun `티켓 단건 생성`() {
        val ticket = ticketGenerator.tickets(1000).tickets.first()
        assertTrue(ticket.numbers.isNotEmpty())
    }

    @Test
    fun `티켓 다건 생성`() {
        val tickets = ticketGenerator.tickets(15300).tickets
        assertEquals(15, tickets.size)
    }

}
