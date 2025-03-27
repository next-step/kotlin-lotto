package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TicketModelModelTest {

    @Test
    fun `ticket should contain 6 numbers`(){
        val ticket = TicketModel(listOf(1,2,3,4,5,6))
        assertThat(ticket.numbers).isEqualTo(listOf(1,2,3,4,5,6))
    }

    @Test
    fun `ticket should contain another 6 numbers`(){
        val ticket = TicketModel(listOf(6,5,4,3,2,1))
        assertThat(ticket.numbers).isEqualTo(listOf(6,5,4,3,2,1))
    }
}