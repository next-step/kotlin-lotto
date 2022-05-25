package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class CalculatorTest {
    @Test
    fun `빈 문자열은 0을 반환`() {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.add("")

        // then
        assertThat(result).isEqualTo(0)
    }

    @ParameterizedTest(name = "{0} => {1}")
    @CsvSource(
        "1,2,3=6",
        "17,5,0=22",
        delimiterString = "=",
    )
    fun `콤마 구분자`(input: String, expected: Int) {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.add(input)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} => {1}")
    @CsvSource(
        "1:2:3=6",
        "17:5:0=22",
        delimiterString = "=",
    )
    fun `세미콜론 구분자`(input: String, expected: Int) {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.add(input)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} => {1}")
    @CsvSource(
        "1,2:3=6",
        "1:2,3=6",
        "17:5:0,99,1=122",
        delimiterString = "=",
    )
    fun `콤마+세미콜론 구분자`(input: String, expected: Int) {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.add(input)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} => {1}")
    @CsvSource(
        "999=999",
        "1=1",
        "10000=10000",
        delimiterString = "=",
    )
    fun `한개의 숫자인 경우 해당 숫자를 반환`(input: String, expected: Int) {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.add(input)

        // then
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} => 예외")
    @ValueSource(
        strings = [
            "-1",
            "-1,99",
            "1,2,3,-4",
        ]
    )
    fun `음수인 경우 예외 발생`(input: String) {
        // given
        val calculator = Calculator()

        // when
        // then
        assertThrows<RuntimeException> { calculator.add(input) }
    }

    @ParameterizedTest(name = "{0} => {1}")
    @CsvSource(
        "//;\\n1;2;3=6",
        "//JADE\\n1JADE2JADE3=6",
        "//@@\\n1@@2@@3=6",
        delimiterString = "=",
    )
    fun `커스텀 구분자`(input: String, expected: Int) {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.add(input)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
