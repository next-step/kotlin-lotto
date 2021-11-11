package lotto

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class TicketTest {
    @Test
    fun `로또 티켓에 번호가 6개가 아니라면 예외를 발생한다`() {
        assertAll(
            {
                assertThatExceptionOfType(IllegalArgumentException::class.java)
                    .isThrownBy { Ticket.of(listOf(1, 2, 3, 4, 5)) }
            },
            {
                assertThatExceptionOfType(IllegalArgumentException::class.java)
                    .isThrownBy { Ticket.of(emptyList()) }
            },

            )
    }

    @Test
    fun `로또 티켓에 중복된 번호가 있으면 예외를 발생한다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Ticket.of(listOf(1, 1, 1, 1, 1, 1)) }
    }
}
