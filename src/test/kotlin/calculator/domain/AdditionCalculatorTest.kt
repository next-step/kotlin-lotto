package calculator.domain

import fixture.OperandsFixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class AdditionCalculatorTest {

    @Test
    fun `덧셈 연산을 수행할 수 있다`() {
        // given
        val operands = OperandsFixture.OPERANDS_SUM_OF_SIX

        // when
        val answer = AdditionCalculator.calculate(operands)

        // then
        Assertions.assertThat(answer).isEqualTo(6)
    }
}
