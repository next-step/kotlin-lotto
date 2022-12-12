package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class OperatorTest {

    @Test
    fun `더하기 연산자를 이용한 덧셈`() {
        // given
        val operator = Operator.PLUS
        val firstOperand = 1
        val secondOperand = 1

        // when
        val actual = operator.calculator(firstOperand, secondOperand)

        // then
        val expected = 2
        assertThat(actual).isEqualTo(expected)
    }
}
