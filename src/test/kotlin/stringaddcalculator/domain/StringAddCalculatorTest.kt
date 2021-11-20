package stringaddcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun `쉼표를 기준으로 분리한 각 숫자의 합을 반환한다`(input: String) {
        assertThat(StringAddCalculator().calculate(input)).isSameAs(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1:2"])
    fun `콜론을 기준으로 분리한 각 숫자의 합을 반환한다`(input: String) {
        assertThat(StringAddCalculator().calculate(input)).isSameAs(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1:2,3"])
    fun `쉼표 또는 콜론을 기준으로 분리한 각 숫자의 합을 반환한다`(input: String) {
        assertThat(StringAddCalculator().calculate(input)).isSameAs(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " "])
    fun `빈값이면 0을 반환한다`(input: String) {
        assertThat(StringAddCalculator().calculate(input)).isSameAs(0)
    }

    @DisplayName(value = "//와 \n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["//^\n1^2:3,4"])
    fun customDelimiter(input: String) {
        assertThat(StringAddCalculator().calculate(input)).isSameAs(10)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "1,-2"])
    fun `음수를 전달하는 경우 RuntimeException 예외 처리를 한다`(input: String) {
        assertThatThrownBy {
            StringAddCalculator().calculate(input)
        }.isInstanceOf(RuntimeException::class.java)
    }
}
