package stringadder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ParserTest {

    @DisplayName("구분자가 포함되지 않은 문자열을 입력 받은 경우 기본 구분자를 기준으로 구분된 숫자 반환")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1:2:3"])
    fun initWithoutCustomDelimiter(input: String) {
        val expected = createOperands("1", "2", "3")

        val actual = Parser(input).operands

        assertThat(actual.operands.containsAll(expected.operands)).isTrue
    }

    @DisplayName("구분자가 포함된 문자열을 입력 받은 경우 구분자들을 기준으로 구분된 숫자 반환")
    @ParameterizedTest
    @ValueSource(strings = ["//a\\n1a2a3", "//a\\n1,2,3", "//a\\n1:2:3"])
    fun initWithCustomDelimiter(input: String) {
        val expected = createOperands("1", "2", "3")

        val actual = Parser(input).operands

        assertThat(actual.operands.containsAll(expected.operands)).isTrue
    }

    @DisplayName("두개 이상의 구분자가 포함된 문자열을 입력 받은 경우 구분자들을 기준으로 구분된 숫자 반환")
    @Test
    fun initWithCustomDelimiter_multipleDelimiter() {
        val input = "//ab\\n1ab2ab3"
        val expected = createOperands("1", "2", "3")

        val actual = Parser(input).operands

        assertThat(actual.operands.containsAll(expected.operands)).isTrue
    }

    @DisplayName("구분자를 잘못 입력한 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = ["/;\\n", "//;\n"])
    fun init_exception(input: String) {
        assertThrows<IllegalArgumentException> { Parser(input) }
    }
}
