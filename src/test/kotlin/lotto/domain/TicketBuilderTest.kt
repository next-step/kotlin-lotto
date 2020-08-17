package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TicketBuilderTest {
    @ParameterizedTest
    @ValueSource(ints = [5000, 5100, 5200, 5500, 5900, 5999])
    fun `howMuchTickets() 5천원이상 6천원 이하를 받으면 5장을 산다`(cost: Int) {
        assertThat(TicketBuilder.sellTickets(cost).size).isEqualTo(5)
    }

    @Test
    fun `티켓을 수동으로 입력받는다`() {
        assertThat(TicketBuilder.sellTicketsManually(DUMMY_TICKET_STRINGS))
            .isEqualTo(listOf(Ticket(setOf(1, 2, 3, 4, 5, 6))))
    }

    @Test
    fun `수동구매 갯수만큼 티켓을 수동으로 입력받는다`() {
        assertThat(TicketBuilder.sellTicketsManually(DUMMY_TICKETS_STRINGS))
            .isEqualTo(
                listOf(
                    Ticket(setOf(1, 2, 3, 4, 5, 6)),
                    Ticket(setOf(1, 2, 3, 4, 5, 7)),
                    Ticket(setOf(1, 2, 3, 4, 5, 8)),
                    Ticket(setOf(1, 2, 3, 4, 5, 9))
                )
            )
    }

    companion object {
        val DUMMY_TICKET_STRINGS = listOf("1, 2, 3, 4, 5, 6")
        val DUMMY_TICKETS_STRINGS = listOf(
            "1, 2, 3, 4, 5, 6",
            "1, 2, 3, 4, 5, 7",
            "1, 2, 3, 4, 5, 8",
            "1, 2, 3, 4, 5, 9"
        )
    }
}
