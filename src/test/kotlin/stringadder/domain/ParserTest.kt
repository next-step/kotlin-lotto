package stringadder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ParserTest {

    @DisplayName("구분자가 포함되지 않은 문자열을 입력 받은 경우")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1:2:3"])
    fun parse(input: String) {
        val expression = Parser.parse(input)

        assertThat(expression.result()).isEqualTo(6)
    }

    @DisplayName("구분자가 포함된 문자열을 입력 받은 경우 구분자들을 기준으로 구분된 숫자 반환")
    @ParameterizedTest
    @ValueSource(strings = ["//a\\n1a2a3", "//a\\n1,2,3", "//a\\n1:2:3"])
    fun parse2(input: String) {
        val expression = Parser.parse(input)

        assertThat(expression.result()).isEqualTo(6)
    }

    @DisplayName("두개 이상의 구분자가 포함된 문자열을 입력 받은 경우 구분자들을 기준으로 구분된 숫자 반환")
    @Test
    fun parse3() {
        val input = "//ab\\n1ab2ab3"
        val expression = Parser.parse(input)

        assertThat(expression.result()).isEqualTo(6)
    }

    @DisplayName("구분자를 잘못 입력한 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = ["/;\\n", "//;\n"])
    fun init_exception(input: String) {
        assertThrows<IllegalArgumentException> { Parser.parse(input) }
    }
}
