package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AddStringCalculatorTest {

    @Test
    fun `수식을 이용하여 계산에 성공한다`() {
        // given
        val expression = Expression.create("2,2,2,2", Delimiters())
        val calculator = AddStringCalculator()

        // when
        val actual = calculator.calculate(expression)

        // then
        val expected = 8
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `빈 수식으로 계산결과가 0이된다`() {
        // given
        val expression = Expression.create("", Delimiters())

        // when
        val actual = AddStringCalculator().calculate(expression)

        // then
        val expected = 0
        assertThat(actual).isEqualTo(expected)
    }
}
