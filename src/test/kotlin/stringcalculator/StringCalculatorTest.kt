package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorTest {
    @Test
    fun `return the sum of numbers split by comma`() {
        // given
        val stringCalculator = StringCalculator()
        val actual = 6

        // when
        val expected = stringCalculator.add("1,2,3")

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `return the sum of numbers split by colon`() {
        // given
        val stringCalculator = StringCalculator()
        val actual = 6

        // when
        val expected = stringCalculator.add("1:2:3")

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ValueSource(strings = ["//;\n1;2;3", "//|\n1|2|3", "//A\n1A2A3"])
    @ParameterizedTest
    fun `return the sum of numbers split by custom delimiter`(expression: String) {
        // given
        val stringCalculator = StringCalculator()
        val actual = 6

        // when
        val expected = stringCalculator.add(expression)

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
