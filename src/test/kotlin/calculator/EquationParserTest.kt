package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

internal class EquationParserTest {

    @ValueSource(strings = [" ", ""])
    @ParameterizedTest
    fun `공백인 경우 0을 반환함`(input: String) {
        assertThat(EquationParser.parse(input))
            .flatExtracting(Operand::operand)
            .containsExactly(0)
    }

    @ParameterizedTest
    @MethodSource("oneNumber")
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환`(input: String, expectedResult: Int) {
        assertThat(EquationParser.parse(input))
            .flatExtracting(Operand::operand)
            .containsExactly(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("commaDelimiter")
    fun `숫자 두개를 컴마(,) 구분자로 구분`(input: String, expectedResult: List<Int>) {
        assertThat(EquationParser.parse(input))
            .flatExtracting(Operand::operand)
            .isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("colonDelimiter")
    fun `숫자 두개를 컴마(,)와 콜론 구분자로 구분`(input: String, expectedResult: List<Int>) {
        assertThat(EquationParser.parse(input))
            .flatExtracting(Operand::operand)
            .isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @MethodSource("customDelimiter")
    fun `커스텀 구분자 사용`(input: String, expectedResult: List<Int>) {
        assertThat(EquationParser.parse(input))
            .flatExtracting(Operand::operand)
            .isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        fun `oneNumber`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1", 1),
                Arguments.of("99", 99),
                Arguments.of("0", 0),
            )
        }

        @JvmStatic
        fun `commaDelimiter`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1, 10", listOf(1, 10)),
                Arguments.of("99, 2", listOf(99, 2)),
                Arguments.of("0, 7", listOf(0, 7)),
            )
        }

        @JvmStatic
        fun `colonDelimiter`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1, 5:10", listOf(1, 5, 10)),
                Arguments.of("99, 2:111", listOf(99, 2, 111)),
                Arguments.of("0, 7:6", listOf(0, 7, 6)),
            )
        }

        @JvmStatic
        fun `customDelimiter`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//a\n1a 5a10", listOf(1, 5, 10)),
                Arguments.of("//;\n99; 2;111", listOf(99, 2, 111)),
                Arguments.of("//ㅎ\n0ㅎ 7ㅎ6", listOf(0, 7, 6)),
            )
        }
    }
}
