package specific.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TicketMachineTest {

    @Test
    fun `수동으로 구매할 로또의 가격보다 남은 돈이 많아야 한다`() {
        // given
        val money = Money(Ticket.PRICE * 1)
        val manualNumbers =
            List(2) { Number.getNumberPool().map { it.value }.subList(0, Ticket.NUMBERS_SIZE).let(::MarkedNumbers) }
        val ticketMachine = TicketMachine()

        // when, then
        assertThrows<IllegalStateException> { ticketMachine.sellTickets(money, manualNumbers) }
    }

    @Test
    fun `수동으로 입력한 번호에 따라 먼저 로또를 구매한다`() {
        // given
        val money = Money(Ticket.PRICE * 3)
        val manualNumbers =
            List(1) { Number.getNumberPool().map { it.value }.subList(0, Ticket.NUMBERS_SIZE).let(::MarkedNumbers) }
        val ticketMachine = TicketMachine()

        // when
        val tickets = ticketMachine.sellTickets(money, manualNumbers)

        // then
        assertEquals(manualNumbers[0].values, tickets.manualTickets[0].numbers)
    }

    @ParameterizedTest
    @CsvSource("1000,100,0", "5000,1000,4")
    fun `남은 돈으로 가능한만큼 로또를 구매한다`(principal: Long, spentAmount: Long, count: Int) {
        // given
        val money = Money(principal)
        money.spend(spentAmount)
        val ticketMachine = TicketMachine()

        // when
        val tickets = ticketMachine.sellTickets(money, emptyList())

        // then
        assertEquals(count, tickets.manualTickets.size + tickets.autoTickets.size)
    }
}
