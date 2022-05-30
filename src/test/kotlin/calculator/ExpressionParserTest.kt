package calculator

import calculator.domain.Expression
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullSource
import java.util.stream.Stream

internal class ExpressionParserTest {

    private val expressionParser = ExpressionParser()

    @ParameterizedTest
    @MethodSource("expressionArguments")
    fun `Expression을 파싱할 수 있다`(input: String, expected: Expression) {
        val result = expressionParser.parse(input)
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @EmptySource
    @NullSource
    fun `빈 문자열이나 null은 0을 반환한다`(input: String?) {
        val result = expressionParser.parse(input)
        assertThat(result).isEqualTo(Expression(listOf(0)))
    }

    companion object {
        @JvmStatic
        fun expressionArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1", Expression(listOf(1))),
                Arguments.of("1,2", Expression(listOf(1, 2))),
                Arguments.of("1,2,3", Expression(listOf(1, 2, 3))),
                Arguments.of("100,200", Expression(listOf(100, 200))),
                Arguments.of("4,3,2,1", Expression(listOf(4, 3, 2, 1))),
                Arguments.of("//;\n1;2;3", Expression(listOf(1, 2, 3))),
                Arguments.of("//$\n1$2$3", Expression(listOf(1, 2, 3))),
            )
        }
    }
}
