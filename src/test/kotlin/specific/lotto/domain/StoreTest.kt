package specific.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StoreTest {

    @ParameterizedTest
    @CsvSource("0", "1000", "5500")
    fun `입력한 돈으로 가능한만큼 로또를 구매한다`(principal: Int) {
        // given
        val money = Money(principal)
        val store = Store()

        // when
        val tickets: List<Ticket> = store.buyTickets(money)

        // then
        assertEquals(principal / Ticket.PRICE, tickets.size)
    }

}
