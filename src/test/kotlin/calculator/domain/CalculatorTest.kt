package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculatorTest {
    @DisplayName("덧셈 테스트")
    @Test
    fun `덧셈 테스트`() {
        val calculator = Calculator()
        val given = calculator.add(arrayOf(PositiveOperand(1), PositiveOperand(2), PositiveOperand(3)))
        val expected = PositiveOperand(6)
        assertThat(given).isEqualTo(expected)
    }
}
