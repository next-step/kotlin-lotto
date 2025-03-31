package lotto.model

import org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class PurchasedTicketsTest {
    private val testGenerator = TestTicketNumberGenerator(listOf(1, 2, 3, 4, 5, 6))

    @Test
    fun `should calculate correct number of tickets based on purchased amount`() {
        val purchasedTickets = PurchasedTickets.buyTickets(5000, testGenerator)
        assertThat(purchasedTickets.getTickets().size).isEqualTo(5)
    }

    @Test
    fun `should generate tickets with correct numbers using generator`() {
        val purchasedTickets = PurchasedTickets.buyTickets(1000, testGenerator)
        assertThat(purchasedTickets.getTickets().first()).isEqualTo(TicketModel(listOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun `should return empty list if purchased amount less that ticket price`() {
        val purchasedTickets = PurchasedTickets.buyTickets(999, testGenerator)
        assertThat(purchasedTickets.getTickets().size).isEqualTo(0)
    }

    class TestTicketNumberGenerator(private val fixedNumbers: List<Int>) : TicketNumberGenerator {
        override fun generateNumbers(): List<Int> = fixedNumbers
    }
}