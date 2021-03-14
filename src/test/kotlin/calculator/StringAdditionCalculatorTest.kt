package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringAdditionCalculatorTest {
    @Test
    fun `빈 문자열이 주어질 경우, 0을 반환`() {
        val calculator = StringAdditionCalculator()
        assertThat(calculator.calculate("")).isEqualTo(0)
    }
}
