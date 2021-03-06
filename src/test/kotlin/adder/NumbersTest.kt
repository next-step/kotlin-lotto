package adder

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class NumbersTest {
    @Test
    fun create() {
        // given
        val input = listOf("2", "0", "23", "1234")

        // when
        val numbers = Numbers(input)

        // then
        assertThat(numbers).isEqualTo(listOf(
                Numbers(listOf(
                    Number(2),
                    Number(0),
                    Number(23),
                    Number(1234)
        ))))
    }
}