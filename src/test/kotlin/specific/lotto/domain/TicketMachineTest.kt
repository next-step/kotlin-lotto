package specific.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TicketMachineTest {

    @ParameterizedTest
    @CsvSource("1000,1", "5000,5", "500,0")
    fun `입력한 돈으로 가능한만큼 로또를 구매한다`(principal: Long, count: Int) {
        // given
        val money = Money(principal)
        val ticketMachine = TicketMachine()

        // when
        val tickets = ticketMachine.sellTickets(money)

        // then
        assertEquals(count, tickets.size)
    }
}
