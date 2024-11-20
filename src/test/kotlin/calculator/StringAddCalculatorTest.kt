package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringAddCalculatorTest {

    @Test
    fun `올바른 식을 입력하면 답을 반환해야 한다`() {
        // given
        val expression = "1,2:3"

        // when
        val result = StringAddCalculator.calculate(expression)

        // then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun `Null 값을 입력하면 0을 반환해야 한다`() {
        // given
        val expression = null

        // when
        val result = StringAddCalculator.calculate(expression)

        // then
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `빈 값을 입력하면 0을 반환해야 한다`() {
        // given
        val expression = "0"

        // when
        val result = StringAddCalculator.calculate(expression)

        // then
        assertThat(result).isEqualTo(0)
    }

}
