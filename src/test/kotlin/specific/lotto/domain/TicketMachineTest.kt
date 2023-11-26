package specific.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TicketMachineTest {

    @Test
    fun `수동으로 입력한 번호에 따라 먼저 로또를 구매한다`() {
        // given
        val money = Money(Ticket.PRICE * 3)
        val manualNumbers = (Number.MIN_NUMBER..Number.MAX_NUMBER).shuffled().take(Ticket.NUMBERS_SIZE)
        val ticketMachine = TicketMachine()

        // when
        val tickets = ticketMachine.sellTickets(money, listOf(manualNumbers))

        // then
        assertEquals(manualNumbers.map { Number(it) }.toSet(), tickets.manualTickets[0].numbers)
    }

    @ParameterizedTest
    @CsvSource("1000,100,0", "5000,1000,4", "500,0,0")
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
