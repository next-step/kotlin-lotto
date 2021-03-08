package calculator

import calculator.parser.CustomExpressionParser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class StringCalculatorTest {
    private lateinit var calculator: StringCalculator

    @BeforeEach
    fun setUp() {
        val parsers = listOf(CustomExpressionParser())
        calculator = StringCalculator(parsers)
    }

    @Test
    fun `빈 문자열은 결과가 0이다`() {
        assertThat(calculator.add("")).isEqualTo(PositiveNumber.ZERO)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        assertThat(calculator.add(text)).isEqualTo(PositiveNumber.ofString(text))
    }

    @DisplayName("구분자로 쉼표(,)와 콜론(:)을 사용할 수 있다.")
    @ParameterizedTest
    @CsvSource(
        value = [
            "1:2,3|6",
            "1,3|4",
            "1:2|3"
        ],
        delimiter = '|'
    )
    fun `기본 구분자로 덧셈`(expression: String, result: String) {
        assertThat(calculator.add(expression)).isEqualTo(PositiveNumber.ofString(result))
    }

    @DisplayName(value = "//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    fun `커스텀 구분자로 덧셈`() {
        assertThat(calculator.add("""//?\n1?2?3""")).isEqualTo(PositiveNumber(6))
    }

    @Test
    fun `문자열 계산기에 음수를 전달하는 경우 RuntimeException 예외 처리를 한다`() {
        assertThrows<RuntimeException> { calculator.add("-1") }
    }
}
