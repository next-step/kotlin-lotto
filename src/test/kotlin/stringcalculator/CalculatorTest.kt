package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    private lateinit var calculator: Calculator

    @BeforeEach
    fun setUp() {
        calculator = Calculator()
    }

    @ParameterizedTest
    @CsvSource("1,2|3", "1,2,3|6", "1,2,3,4|10", delimiter = '|')
    fun `쉼표로 구분된 숫자들의 합을 반환한다`(input: String, expected: Int) {
        val result = calculator.calculate(input)

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("1:2|3", "1:2:3|6", "1:2:3:4|10", delimiter = '|')
    fun `콜론으로 구분된 숫자들의 합을 반환한다`(input: String, expected: Int) {
        val result = calculator.calculate(input)

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource("1,2:3|6", "1:2,3|6", delimiter = '|')
    fun `쉼표와 콜론의 조합으로 구분된 숫자들의 합을 반환한다`(input: String, expected: Int) {
        val result = calculator.calculate(input)

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = *["&", "|", "!", "!!", "abc"])
    fun `커스텀 구분자로 구분된 숫자들의 합을 반환한다`(customDelimiter: String) {
        val result = calculator.calculate("//${customDelimiter}\n1${customDelimiter}2${customDelimiter}3")

        assertThat(result).isEqualTo(1 + 2 + 3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "10", "100", "1000000"])
    fun `하나의 숫자를 입력하면 그대로 반환한다`(input: String) {
        val result = calculator.calculate(input)

        assertThat(result).isEqualTo(input.toInt())
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null을 입력하면 0을 반환한다`(input: String?) {
        val result = calculator.calculate(input)

        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `숫자 이외의 값을 전달하면 RuntimeException 예외를 throw 한다`() {
        assertThrows<RuntimeException> {
            calculator.calculate("a,b,c")
        }
    }

    @Test
    fun `음수를 전달하면 RuntimeException 예외를 throw 한다`() {
        assertThrows<RuntimeException> {
            calculator.calculate("-1,-2,-3")
        }
    }
}
