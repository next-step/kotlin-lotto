package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class NumberTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "'//;\n1;2;3' > true",
            "'1,2,3' > false"
        ],
        delimiterString = ">"
    )
    fun `커스텀 구분자 포함 여부 판단`(string: String, expected: Boolean) {
        assertThat(hasCustomDelimeter(string)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "'//;\n1;2;3' > ;",
            "'//*\n12*13*14' > *"
        ],
        delimiterString = ">"
    )
    fun `커스텀 구분자 구하기`(string: String, expected: String) {
        assertThat(customDelimeter(string)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("generateParsingTestData")
    fun `구분자를 기준으로 문자열 파싱`(string: String, delimiter: String, expected: List<String>) {
        assertThat(parse(string, delimiter)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "1, true",
        "A, false",
        "0, true",
        "-1, false"
    )
    fun `파싱된 문자가 자연수인지 확인`(string: String, expected: Boolean) {
        assertThat(Number(string).isNatural()).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun generateParsingTestData(): List<Arguments> {
            return listOf(
                Arguments.of("1;2;3", ";", listOf("1", "2", "3")),
                Arguments.of("12*13*14", "*", listOf("12", "13", "14"))
            )
        }
    }
}
