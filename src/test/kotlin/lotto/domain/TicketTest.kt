package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class TicketTest {
    @Test
    fun `constructor() 45가 넘는 정수를 입력받으면 RuntimeException 발생`() {
        assertThatThrownBy {
            Ticket(1, 2, 3, 4, 5, 46)
        }.isInstanceOf(RuntimeException::class.java)
    }

    @Test
    fun `constructor() 0 이하의 정수를 입력 받으면 RuntimeException 발생`() {
        assertThatThrownBy {
            Ticket(1, 2, 3, 4, 5, 0)
        }.isInstanceOf(RuntimeException::class.java)
    }

    @Test
    fun `constructor() 중복된 정수를 입력 받으면 RuntimeException 발생`() {
        assertThatThrownBy {
            Ticket(1, 2, 3, 4, 5, 1)
        }.isInstanceOf(RuntimeException::class.java)
    }

    @Test
    fun `countMatches() 동일한 숫자 갯수를 찾는다`() {
        assertThat(
            Ticket(1, 2, 3, 4, 5, 6).countMatches(
                Ticket(6, 5, 4, 3, 2, 1)
            )
        ).isEqualTo(6)

        assertThat(
            Ticket(1, 2, 3, 4, 5, 6).countMatches(
                Ticket(16, 5, 4, 3, 2, 1)
            )
        ).isEqualTo(5)

        assertThat(
            Ticket(1, 2, 3, 4, 5, 6).countMatches(
                Ticket(16, 15, 4, 3, 2, 1)
            )
        ).isEqualTo(4)

        assertThat(
            Ticket(1, 2, 3, 4, 5, 6).countMatches(
                Ticket(16, 15, 14, 13, 12, 11)
            )
        ).isEqualTo(0)
    }
}
