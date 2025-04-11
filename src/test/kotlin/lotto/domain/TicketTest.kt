package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TicketTest {
    @Test
    fun `fail when under 6 numbers is entered`() {
        assertThrows<IllegalArgumentException> {
            Ticket(listOf(1, 2, 3, 4, 5))
        }
    }
}
