package expressioncalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    private val calculator = Calculator(
        inputConverter = InputConverter,
        expressionParser = ExpressionParser
    )

    @ParameterizedTest
    @CsvSource(value = ["1,3,4=8", "10,30,1,50=91", "1:2:3=6", "34:13:1=48"], delimiter = '=')
    fun `Calculator는 쉼표 또는 콜론으로 구분된 숫자문자열을 받아 숫자의 합을 구할 수 있다`(input: String, expected: Int) {
        assertThat(calculator.calculate(input)).isEqualTo(expected)
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정하여 숫자의 합을 구할 수 있다")
    @ParameterizedTest
    @ValueSource(strings = ["//!\n1!2!3!4"])
    fun customDelimiter(input: String) {
        assertThat(calculator.calculate(input)).isEqualTo(10)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 받을 경우 0을 반환한다`(input: String?) {
        assertThat(calculator.calculate(input)).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(value = ["1=1", "100=100", "269=269", "77=77"], delimiter = '=')
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(input: String, expected: Int) {
        assertThat(calculator.calculate(input)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-100", "-123123:3:121", "-62497,-12,-80"])
    fun `문자열에 음수가 포함되는 경우 RuntimeException이 발생한다`(input: String) {
        assertThrows<RuntimeException> {
            calculator.calculate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "1:3:git", "1,jpg,11,3,png", "1, 2, 3"])
    fun `문자열에 숫자로 변환할 수 없는 값이 포함되는 경우 RuntimeException이 발생한다`(input: String) {
        assertThrows<RuntimeException> {
            calculator.calculate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1:2:", ":3:1", "1::7", ":4:8", "5::"])
    fun `구분자 전후에 값이 비어있을 경우 RuntimeException이 발생한다`(input: String) {
        assertThrows<RuntimeException> {
            calculator.calculate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1;3", "9,8,7$5"])
    fun `커스텀 구분자 정의 없이 기본 구분자가 아닌 구분자를 사용할 경우 RuntimeException이 발생한다`(input: String) {
        assertThrows<RuntimeException> {
            calculator.calculate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["//!\n1,2,3,4", "//!\n1?2?3?4", "//!\n1!2@3!4"])
    fun `정의된 커스텀 구분자 이외의 구분자를 사용할 경우 RuntimeException이 발생한다`(input: String) {
        assertThrows<RuntimeException> {
            calculator.calculate(input)
        }
    }
}
