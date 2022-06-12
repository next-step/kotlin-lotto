package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class EquationParserTest {

    @ValueSource(strings = [" ", ""])
    @ParameterizedTest
    fun `공백인 경우 0을 반환함`(input: String) {
        assertThat(EquationParser.parse(input))
            .flatExtracting(Operand::operand)
            .containsExactly(0)
    }

    @MethodSource("oneNumber")
    @ParameterizedTest
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환`(input: String, expectedResult: Int) {
        assertThat(EquationParser.parse(input))
            .flatExtracting(Operand::operand)
            .containsExactly(expectedResult)
    }

    companion object {
        fun oneNumber(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments("1", 1),
                Arguments.arguments("99", 99),
            )
        }
    }
}