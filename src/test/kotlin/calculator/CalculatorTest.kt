package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @EmptySource
    fun `빈 문자열을 입력할 경우 0을 반환한다`(input: String) {
        val sum = Calculator.add(input)

        assertThat(sum).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "4", "9"])
    fun `하나의 숫자만 입력받았을 경우 해당 값을 그대로 리턴한다`(input: String) {
        val sum = Calculator.add(input)

        assertThat(sum).isSameAs(input.toInt())
    }
}
