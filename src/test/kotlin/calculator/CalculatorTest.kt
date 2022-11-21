package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ValueSource(strings = ["1,2,3,4"])
    @ParameterizedTest
    fun `정상 계산 확인 - 기본 구분자`(expression: String) {
        assertThat(Calculator.calculate(expression)).isEqualTo(10)
    }

    @ValueSource(strings = ["//;\n1;2;3;4"])
    @ParameterizedTest
    fun `정상 계산 확인 - 커스텀 구분자`(expression: String) {
        assertThat(Calculator.calculate(expression)).isEqualTo(10)
    }

    @ValueSource(strings = ["//;\n1+2;3;4"])
    @ParameterizedTest
    fun `비정상 계산 확인 - 숫자 이와 포함`(expression: String) {
        assertThrows<RuntimeException> { Calculator.calculate(expression) }
    }

    @ValueSource(strings = ["//;\n1;2;-3;4"])
    @ParameterizedTest
    fun `비정상 계산 확인 - 음수 확인`(expression: String) {
        assertThrows<RuntimeException> { Calculator.calculate(expression) }
    }
}
