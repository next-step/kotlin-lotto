package calculator

import calculator.domain.StringAddCalculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {

    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(text: String?) {
        assertThat(calculator.add(text)).isZero
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "3", "4", "10", "11"])
    fun `숫자 하나를 입력한 경우 해당 숫자가 반환되어야 한다`(text: String) {
        assertThat(calculator.add(text)).isEqualTo(text.toInt())
    }

    @ParameterizedTest
    @CsvSource(value = ["11,10|21", "31,20|51", "100,200|300"], delimiterString = "|")
    fun `숫자 두개를 쉼표(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(text: String, result: Int) {
        assertThat(calculator.add(text)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["31:20|51", "11:2|13"], delimiterString = "|")
    fun `구분자를 쉼표(,) 이외에 콜론 을 사용할 수 있다`(text: String, result: Int) {
        assertThat(calculator.add(text)).isEqualTo(result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    fun customDelimiter(text: String) {
        assertThat(calculator.add(text)).isEqualTo(6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-111"])
    fun `음수가 전달될 경우 런타임 에러가 발생한다`(text: String) {
        assertThrows<RuntimeException> { calculator.add(text) }
    }
}
