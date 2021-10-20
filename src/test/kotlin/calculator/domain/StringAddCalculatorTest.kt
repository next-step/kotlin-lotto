package calculator.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator(InputExpressionParser())
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력하면 0을 반환해야 한다`(input: String?) {
        assertThat(calculator.calculate(input)).isZero
    }

    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(input: String) {
        assertThat(calculator.calculate(input)).isSameAs(Integer.parseInt(input))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun `숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(input: String) {
        assertThat(calculator.calculate(input)).isSameAs(3)
    }

    @DisplayName("구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun colonsDelimiter(input: String) {
        assertThat(calculator.calculate(input)).isSameAs(6)
    }

    @DisplayName("//\"와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun customDelimiter(input: String) {
        assertThat(calculator.calculate(input)).isSameAs(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-100", "-1000"])
    fun `문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다`(input: String) {
        Assertions.assertThatThrownBy {
            calculator.calculate(input)
        }.isInstanceOf(RuntimeException::class.java)
    }
}
