package lotto.model

import org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class PurchasedTicketsTest {

    @Test
    fun `should calculate correct number of tickets based on purchased amount`() {
        val tickets = PurchasedTickets(5000);
        assertThat(tickets.ticketCount).isEqualTo(5)
    }
}