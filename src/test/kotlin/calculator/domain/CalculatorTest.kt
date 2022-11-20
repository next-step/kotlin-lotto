package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalculatorTest {
    @DisplayName("덧셈 테스트")
    @Test
    fun `덧셈 테스트`() {
        val calculator = Calculator()
        val given = calculator.add(arrayOf(Operand(1), Operand(2), Operand(3)))
        val expected = Operand(6)
        assertThat(given).isEqualTo(expected)
    }
}
