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

    @Test
    fun `빼기 연산자를 이용한 뺄셈`() {
        // given
        val operator = Operator.MINUS
        val firstOperand = 1
        val secondOperand = 1

        // when
        val actual = operator.calculator(firstOperand, secondOperand)

        // then
        val expected = 0
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `곱셈 연산자를 이용한 곱셈`() {
        // given
        val operator = Operator.MULTIPLY
        val firstOperand = 1
        val secondOperand = 1

        // when
        val actual = operator.calculator(firstOperand, secondOperand)

        // then
        val expected = 1
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `나누기 연산자를 이용한 나눗셈`() {
        // given
        val operator = Operator.DIVIDE
        val firstOperand = 1
        val secondOperand = 1

        // when
        val actual = operator.calculator(firstOperand, secondOperand)

        // then
        val expected = 1
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `0이 포함된 피연산자를 이용한 나눗셈`() {
        // given
        val operator = Operator.DIVIDE
        val firstOperand = 1
        val secondOperand = 0

        // when
        val actual = operator.calculator(firstOperand, secondOperand)

        // then
        val expected = 0
        assertThat(actual).isEqualTo(expected)
    }
}
