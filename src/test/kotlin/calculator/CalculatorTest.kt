package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource

class CalculatorTest {

    @ParameterizedTest
    @EmptySource
    fun `빈 문자열을 입력할 경우 0을 반환한다`(input: String) {
        val sum = Calculator.add(input)

        assertThat(sum).isEqualTo(0)
    }
}
