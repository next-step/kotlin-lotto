package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private val calculator = StringAddCalculator()

    @Test
    fun `입력값이 빈 문자열 또는 null인 경우 0을 반환`() {
        assertThat(calculator.calculate("")).isEqualTo(0)
        assertThat(calculator.calculate(null)).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "5", "17"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자 반환`(text: String) {
        assertThat(calculator.calculate(text)).isEqualTo(text.toInt())
    }
}
