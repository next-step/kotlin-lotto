package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ManualTicketBuilderTest {
    @Test
    fun `티켓을 수동으로 입력받는다`() {
        assertThat(ManualTicketBuilder.sellTickets(DUMMY_TICKET_STRINGS))
            .isEqualTo(listOf(Ticket(setOf(1, 2, 3, 4, 5, 6))))
    }

    @Test
    fun `수동구매 갯수만큼 티켓을 수동으로 입력받는다`() {
        assertThat(ManualTicketBuilder.sellTickets(DUMMY_TICKETS_STRINGS))
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
