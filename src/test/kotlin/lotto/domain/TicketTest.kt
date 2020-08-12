package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class TicketTest {
    @Test
    fun `constructor() 45가 넘는 정수를 입력받으면 RuntimeException 발생`() {
        assertThatThrownBy {
            Ticket(setOf(1, 2, 3, 4, 5, 46))
        }.isInstanceOf(RuntimeException::class.java)
    }

    @Test
    fun `constructor() 0 이하의 정수를 입력 받으면 RuntimeException 발생`() {
        assertThatThrownBy {
            Ticket(setOf(1, 2, 3, 4, 5, 0))
        }.isInstanceOf(RuntimeException::class.java)
    }

    @Test
    fun `constructor() 중복된 정수를 입력 받으면 RuntimeException 발생`() {
        assertThatThrownBy {
            Ticket(setOf(1, 2, 3, 4, 5, 1))
        }.isInstanceOf(RuntimeException::class.java)
    }

    @ParameterizedTest
    @MethodSource("provideTicketsForMatch")
    fun `countMatches() 동일한 숫자 갯수를 찾는다`(ticket: Ticket, count: Int) {
        assertThat(
            TICKET.countMatches(ticket)
        ).isEqualTo(count)
    }

    companion object {
        val TICKET = Ticket(setOf(1, 2, 3, 4, 5, 6))

        @JvmStatic
        private fun provideTicketsForMatch(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Ticket(setOf(6, 5, 4, 3, 2, 1)), 6),
                Arguments.of(Ticket(setOf(16, 5, 4, 3, 2, 1)), 5),
                Arguments.of(Ticket(setOf(16, 15, 4, 3, 2, 1)), 4),
                Arguments.of(Ticket(setOf(16, 15, 14, 3, 2, 1)), 3),
                Arguments.of(Ticket(setOf(16, 15, 14, 13, 2, 1)), 2),
                Arguments.of(Ticket(setOf(16, 15, 14, 13, 12, 1)), 1),
                Arguments.of(Ticket(setOf(16, 15, 14, 13, 12, 11)), 0)
            )
        }
    }
}
