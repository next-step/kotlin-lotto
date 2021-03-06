package adder

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class NumberTest {
    @Test
    fun create() {
        // given
        val stringInput = "3"

        // when
        val number = Number(stringInput)

        // then
        assertThat(number).isEqualTo(Number(3))
    }

    @Test
    fun createWhenNegative() {
        // when, then
        assertThrows<IllegalArgumentException> { Number(-2) }
    }
}
