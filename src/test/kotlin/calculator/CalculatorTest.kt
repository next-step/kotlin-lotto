package calculator

import calculator.domain.Calculator
import calculator.domain.Translator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @CsvSource("1,2,3;6", "4,5:6;15", ":2:3;5", ":2,3;5", "6;6", delimiter = ';')
    internal fun `덧셈 테스트`(input: String, expected: Int) {
        val tokens = Translator.run(input)
        val result = Calculator.run(tokens)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    internal fun `커스텀 구분자 덧셈 테스트`(input: String) {
        val tokens = Translator.run(input)
        val result = Calculator.run(tokens)
        val expected = 6
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(",2,3;5", "4, :6;10", "5,5:;10", delimiter = ';')
    internal fun `각 token에 blank 입력 테스트`(input: String, expected: Int) {
        val tokens = Translator.run(input)
        val result = Calculator.run(tokens)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("a,2,3", "한글,3", "@,3,4")
    internal fun `숫자 이외 값 예외 테스트`(input: String) {
        assertThrows<RuntimeException> {
            val tokens = Translator.run(input)
            Calculator.run(tokens)
        }
    }

    @ParameterizedTest
    @CsvSource("-1,2,3", "-2,-3")
    internal fun `음수 예외 테스트`(input: String) {
        assertThrows<RuntimeException> {
            val tokens = Translator.run(input)
            Calculator.run(tokens)
        }
    }
}
