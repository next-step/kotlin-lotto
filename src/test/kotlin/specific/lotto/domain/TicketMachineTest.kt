package specific.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TicketMachineTest {

    @ParameterizedTest
    @CsvSource("1000,100,0", "5000,1000,4", "500,0,0")
    fun `남은 돈으로 가능한만큼 로또를 구매한다`(principal: Long, spentAmount: Long, count: Int) {
        // given
        val money = Money(principal)
        money.spend(spentAmount)
        val ticketMachine = TicketMachine()

        // when
        val tickets = ticketMachine.sellTickets(money)

        // then
        assertEquals(count, tickets.size)
    }
}
