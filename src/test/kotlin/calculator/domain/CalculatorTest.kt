package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CalculatorTest {

    @Test
    fun `수식을 이용하여 계산에 성공한다`() {
        // given
        val expression = Expression("123")
        val calculator = Calculator(expression)

        // when
        val actual = calculator.calculate()

        // then
        val expected = 6
        assertThat(actual).isEqualTo(expected)
    }

}