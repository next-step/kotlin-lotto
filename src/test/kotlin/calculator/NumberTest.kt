package calculator

import calculator.infrastructure.Calculator
import calculator.infrastructure.Number
import calculator.infrastructure.customDelimeter
import calculator.infrastructure.parse
import calculator.infrastructure.validate
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun `전체 메소드 테스트`(text: String) {
        val validatedString = validate(text)
        val customDelimiter = customDelimeter(validatedString)
        val list = parse(validatedString, customDelimiter)
        val numbers = list.filter { Number(it).isNatural() }.map { it.toInt() }
        val sum = Calculator().sum(numbers)

        assertThat(sum).isEqualTo(6)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "'//;\n1;2;3' > ;",
            "'//*\n12*13*14' > *",
            "'//#\n12#13#14' > #"
        ],
        delimiterString = ">"
    )
    fun `커스텀 구분자 구하기`(string: String, expected: String) {
        assertThat(customDelimeter(string)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("generateParsingTestData")
    fun `구분자를 기준으로 문자열 파싱`(string: String, delimiter: String, expected: List<String>) {
        val parse = parse(string, delimiter)
        assertThat(parse(string, delimiter)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "1, true",
        "0, true"
    )
    fun `파싱된 문자가 자연수인 경우`(string: String, expected: Boolean) {
        assertThat(Number(string).isNatural()).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["A", "-1"])
    fun `파싱된 문자가 자연수가 아닌 경우`(string: String) {
        assertThatIllegalArgumentException().isThrownBy { Number(string).isNatural() }
    }

    companion object {
        @JvmStatic
        fun generateParsingTestData(): List<Arguments> {
            return listOf(
                Arguments.of("//;\n1;2;3", ";", listOf("1", "2", "3")),
                Arguments.of("//*\n12*13*14", "*", listOf("12", "13", "14")),
                Arguments.of("1,2:3", ",|:", listOf("1", "2", "3"))
            )
        }
    }
}
