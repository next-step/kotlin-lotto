package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource


internal class CalculatorTest {
    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUP() {
        calculator = Calculator()
    }

    @DisplayName(value = "빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열이나 Null을 입력하면 0을 반환한다`(text: String?) {
        assertThat(calculator.calculate(text)).isZero
    }

    @DisplayName(value = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun `숫자 하나를 입력할 경우 해당 숫자를 그대로 반환한다`(text: String) {
        assertThat(calculator.calculate(text)).isSameAs(text.toInt())
    }

    @DisplayName(value = "숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun `쉼표(,)를 가지는 문자열을 받아서 구분자를 기준으로 분리한 숫자의 합을 반환한다`(text: String) {
        assertThat(calculator.calculate(text)).isSameAs(3)
    }

    @DisplayName(value = "구분자를 쉼표(,) 이외에 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun `쉼표나 콜론을 가지는 문자열을 받아서 구분자를 기준으로 분리한 숫자의 합을 반환한다`(text: String) {
        assertThat(calculator.calculate(text)).isSameAs(6)
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun `커스텀 구분자를 지정할 수 있다`(text: String) {
        assertThat(calculator.calculate(text)).isSameAs(6)
    }

    @DisplayName(value = "문자열 계산기에 음수나 숫자가 아닌 값을 전달하면 RuntimeException 예외 처리를 한다.")
    @ParameterizedTest
    @ValueSource(strings = ["-1", "안녕하세요"])
    fun `음수를 전달할 경우 RuntimeException 예외가 발생해야 한다`(text: String) {
        assertThatExceptionOfType(RuntimeException::class.java)
            .isThrownBy { calculator.calculate(text) }
    }
}
