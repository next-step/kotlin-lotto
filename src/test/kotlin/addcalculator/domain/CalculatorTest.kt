package addcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `문자열 더하기`() {
        // given
        val stringValues = listOf(StringValue("3"), StringValue("2"), StringValue("1"))

        // when
        val actual = Calculator.sum(stringValues)

        // then
        assertThat(actual).isEqualTo(6)
    }
}
