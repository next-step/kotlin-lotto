package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringAdditionCalculatorTest {
    private val calculator = StringAdditionCalculator()

    @Test
    fun `빈 문자열이 주어질 경우, 0을 반환`() {
        assertThat(calculator.calculate("")).isEqualTo(0)
    }

    @Test
    fun `null이 주어질 경우, 0을 반환`() {
        assertThat(calculator.calculate(null)).isEqualTo(0)
    }
}
