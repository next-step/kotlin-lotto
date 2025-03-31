package lotto.model

import org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class PurchasedTicketsTest {

    @Test
    fun `should calculate correct number of tickets based on purchased amount`() {
        val purchasedTickets = PurchasedTickets.buyTickets(5000)
        assertThat(purchasedTickets.getTickets().size).isEqualTo(5)
    }

    @Test
    fun `should generate tickets based on purchased amount`() {
        val purchasedTickets = PurchasedTickets.buyTickets(1000)
        assertThat(purchasedTickets.getTickets().first()).isEqualTo(TicketModel(listOf(1,2,3,4,5,6)))
    }
}