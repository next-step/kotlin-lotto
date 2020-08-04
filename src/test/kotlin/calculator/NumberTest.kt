package calculator

import calculator.domain.Calculator
import calculator.domain.Number
import calculator.domain.parse
import calculator.domain.validate
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
        val validatedText = validate(text)
        val list = parse(validatedText)
        val numbers = list.map { Number(it).isNature() }
        val sum = Calculator().sum(numbers)

        assertThat(sum).isEqualTo(6)
    }

    @ParameterizedTest
    @MethodSource("generateParsingTestData")
    fun `구분자를 기준으로 문자열 파싱`(text: String, delimiter: String, expected: List<String>) {
        val parse = parse(text)
        assertThat(parse(text)).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "1, 1",
        "0, 0"
    )
    fun `파싱된 문자가 자연수인 경우`(text: String, expected: Int) {
        assertThat(Number(text).isNature()).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["A", "-1"])
    fun `파싱된 문자가 자연수가 아닌 경우`(text: String) {
        assertThatIllegalArgumentException().isThrownBy { Number(text).isNature() }
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
