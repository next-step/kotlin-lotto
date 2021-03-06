package adder

import adder.model.Number
import adder.model.Numbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NumbersTest {
    @Test
    fun create() {
        // given
        val input = listOf("2", "0", "23", "1234")

        // when
        val numbers = Numbers(input)

        // then
        assertThat(numbers).isEqualTo(
            Numbers(
                listOf(
                    Number(2),
                    Number(0),
                    Number(23),
                    Number(1234)
                )
            )
        )
    }

    @Test
    fun getSum() {
        // given
        val input = listOf("2", "23", "50", "0", "100")
        val numbers = Numbers(input)

        // when
        val sum = numbers.getSum()

        // then
        assertThat(sum).isEqualTo(200)
    }
}