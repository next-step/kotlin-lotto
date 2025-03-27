package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class TicketModelModelTest {

    @ParameterizedTest
    @MethodSource("provideNumbers")
    fun `ticket should contain 6 numbers`(numbers: List<Int>) {
        val ticket = TicketModel(numbers)
        assertThat(ticket.numbers).isEqualTo(numbers)
    }

    companion object {
        @JvmStatic
        fun provideNumbers(): List<List<Int>> = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(6, 5, 4, 3, 2, 1),
            listOf(8, 9, 10, 11, 12, 13)
        )
    }
}