package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
}
