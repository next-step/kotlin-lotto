package calculator.domain

import calculator.domain.Calculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열이나 null 값이 입력으로 들어오면 0을 리턴한다")
    fun inputNullOrBlankTest(input: String?) {
        val result = Calculator.run(input)
        assertThat(result).isEqualTo(0)
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자를 입력으로 받을 때 덧셈 기능을 테스트 한다")
    @ValueSource(strings = ["//;\n1;2;3"])
    internal fun customCalculateTest(input: String) {
        val result = Calculator.run(input)
        val expected = 6
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @DisplayName("기본 구분자로 입력을 받을 때 덧셈 기능을 테스트 한다")
    @CsvSource("1,2,3;6", "4,5:6;15", ":2:3;5", ":2,3;5", "6;6", delimiter = ';')
    internal fun defaultCalculateTest(input: String, expected: Int) {
        val result = Calculator.run(input)
        assertThat(result).isEqualTo(expected)
    }

    @Test
    @DisplayName("입력으로 숫자가 하나만 있는 경우 덧셈 기능을 테스트 한다")
    internal fun calculateOneNumberTest() {
        val result = Calculator.run("6")
        assertThat(result).isEqualTo(6)
    }

    @ParameterizedTest
    @DisplayName("입력 token에 blank가 있는 경우 덧셈 기능을 테스트 한다")
    @CsvSource(",2,3;5", "4, :6;10", "5,5:;10", delimiter = ';')
    internal fun calculateBlankTokenTest(input: String, expected: Int) {
        val result = Calculator.run(input)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @DisplayName("입력 token에 not integer type이 있는 경우 덧셈 기능을 테스트 한다")
    @CsvSource("a,2,3", "한글,3", "@,3,4")
    internal fun calculateNotIntegerTokenTest(input: String) {
        assertThrows<RuntimeException> {
            Calculator.run(input)
        }
    }

    @ParameterizedTest
    @DisplayName("입력 token에 음수가 있는 경우 덧셈 기능을 테스트 한다")
    @CsvSource("-1,2,3", "-2,-3")
    internal fun calculateMinusTypeTest(input: String) {
        assertThrows<RuntimeException> {
            Calculator.run(input)
        }
    }
}
