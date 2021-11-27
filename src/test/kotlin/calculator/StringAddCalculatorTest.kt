package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringAddCalculatorTest {
    private val calculator = StringAddCalculator()

    @Test
    fun `입력값이 빈 문자열 또는 null인 경우 0을 반환`() {
        assertThat(calculator.calculate("")).isEqualTo(0)
        assertThat(calculator.calculate(null)).isEqualTo(0)
    }
}
