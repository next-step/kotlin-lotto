package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private val calculator = StringAddCalculator

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다`(input: String?) {
        assertThat(calculator.add(input)).isZero
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(input: String) {
        assertThat(calculator.add(input)).isEqualTo(input.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3"])
    fun `숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(input: String) {
        assertThat(calculator.add(input)).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3", "//+\n1+2+3"])
    fun `커스텀 구분자를 지정할 수 있다`(input: String) {
        assertThat(calculator.add(input)).isEqualTo(6)
    }
}
