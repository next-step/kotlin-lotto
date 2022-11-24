package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculatorTest {
    @DisplayName("덧셈 테스트")
    @Test
    fun `덧셈 테스트`() {
        // given
        val calculator = Calculator
        val expected = PositiveOperand(6)

        // when
        val given = calculator.add(arrayOf(PositiveOperand(1), PositiveOperand(2), PositiveOperand(3)))

        // then
        assertThat(given).isEqualTo(expected)
    }
}
