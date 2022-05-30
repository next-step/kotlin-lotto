package calculator

import calculator.domain.Expression
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class StringAddCalculatorTest {

    private val calculator = StringAddCalculator()

    @ParameterizedTest
    @MethodSource("expressionArguments")
    fun `Expression을 계산할 수 있다`(expression: Expression, expected: Int) {
        val result = calculator.add(expression)

        assertThat(result).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun expressionArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Expression(listOf(1)), 1),
                Arguments.of(Expression(listOf(1, 2)), 3),
                Arguments.of(Expression(listOf(1, 2, 3)), 6),
                Arguments.of(Expression(listOf(100, 200)), 300),
                Arguments.of(Expression(listOf(4, 3, 2, 1)), 10),
            )
        }
    }
}
