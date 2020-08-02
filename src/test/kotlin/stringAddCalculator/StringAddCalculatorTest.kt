package stringAddCalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private val calculator = StringAddCalculator()

    @ParameterizedTest
    @EmptySource
    fun `빈 문자열을 입력할 경우 0을 반환해야 한다`(text: String) {
        val actual = calculator.add(text)
        assertThat(actual).isEqualTo(Number(0))
    }

    @ParameterizedTest
    @ValueSource(strings = ["5"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        assertThat(calculator.add(text)).isEqualTo(Number(text.toInt()))
    }

    @ParameterizedTest
    @ValueSource(strings = ["3,5"])
    fun `쉼표로 구분된 문자열을 더한 값을 리턴한다`(text: String) {
        assertThat(calculator.add(text)).isEqualTo(Number(8))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun `구분자를 컴마 이외에 콜론을 사용할 수 있다`(text: String) {
        assertThat(calculator.add(text)).isEqualTo(Number(6))
    }

    @Test
    fun `숫자 하나를 음수로 입력할 경우 RuntimeException 예외가 발생해야 한다`() {
        assertThatThrownBy { calculator.add("-2") }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("can not use nagative number -2")
    }

    @Test
    fun `여러 문자열 중 하나라도 음수일 경우 RuntimeException 예외가 발생해야 한다`() {
        assertThatThrownBy { calculator.add("1,-2:3") }
            .isInstanceOf(RuntimeException::class.java)
            .hasMessage("can not use nagative number -2")
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\\n1;2,3:4"])
    fun `커스텀 구분자를 지정할 수 있다`(text: String) {
        // "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
        assertThat(calculator.add(text)).isEqualTo(Number(10))
    }
}
