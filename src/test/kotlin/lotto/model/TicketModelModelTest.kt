package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TicketModelModelTest {

    @Test
    fun `ticket should contain 6 numbers`(){
        val ticket = TicketModel(listOf(1,2,3,4,5,6))
        assertThat(ticket.numbers).isEqualTo(listOf(1,2,3,4,5,6))
    }
}