package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class OrderTest {
    @Test
    fun `Throw exception when manual ticket number exceed total ticket number`() {
        // given && when && then
        assertThrows<IllegalArgumentException> {
            Order(
                1000,
                2,
                listOf(),
            )
        }
    }

    @Test
    fun `Does not throw exception when manual ticket number exceed total ticket number`() {
        // given && when && then
        assertDoesNotThrow {
            Order(
                2000,
                2,
                listOf(),
            )
        }
    }

    @Test
    fun `Auto ticket number can be counted by properties`() {
        // given
        val order = Order(2000, 1, listOf())
        val expected = 1

        // when
        val actual = order.autoTicketNumber

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
