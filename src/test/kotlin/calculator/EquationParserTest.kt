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
    }
}