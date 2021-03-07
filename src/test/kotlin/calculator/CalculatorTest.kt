package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1,2:3", "1:2:3", "1:2,3"])
    internal fun `기본 입력 테스트`(input: String) {
        val inputParameter = InputConsole.run(input)
        assertThat(inputParameter).containsOnly(1, 2, 3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    internal fun `커스텀 구분자 입력 테스트`(input: String) {
        val inputParameter = InputConsole.run(input)
        assertThat(inputParameter).containsOnly(1, 2, 3)
    }

    @ParameterizedTest
    @NullAndEmptySource
    internal fun `null or blank 입력 테스트`(input: String?) {
        val inputParameter = InputConsole.run(input)
        assertThat(inputParameter).containsOnly(DEFAULT_TOKEN_VALUE)
    }

    @ParameterizedTest
    @ValueSource(strings = [",1,3", " ,1,3"])
    internal fun `각 token에 blank 입력 테스트`(input: String) {
        val inputParameter = InputConsole.run(input)
        assertThat(inputParameter).containsOnly(DEFAULT_TOKEN_VALUE, 1, 3)
    }

    @ParameterizedTest
    @CsvSource("a,2,3", "한글,3", "@,3,4")
    internal fun `숫자 이외 값 예외 테스트`(input: String) {
        assertThrows<RuntimeException> {
            InputConsole.run(input)
        }
    }

    @ParameterizedTest
    @CsvSource("-1,2,3", "-2,-3")
    internal fun `음수 예외 테스트`(input: String) {
        assertThrows<RuntimeException> {
            InputConsole.run(input)
        }
    }

    @ParameterizedTest
    @CsvSource("1,2,3;6", "4,5:6;15", ":2:3;5", ":2,3;5", "6;6", delimiter = ';')
    internal fun `덧셈 테스트`(input: String, expected: Int) {
        val tokens = InputConsole.run(input)
        assertThat(Calculator.run(tokens)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    internal fun `커스텀 구분자 덧셈 테스트`(input: String) {
        val tokens = InputConsole.run(input)
        assertThat(Calculator.run(tokens)).isEqualTo(6)
    }
}
