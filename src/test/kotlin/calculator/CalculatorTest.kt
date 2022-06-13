package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class CalculatorTest {
    @ParameterizedTest
    @MethodSource("equations")
    fun `식의 합을 구한다`(input: String?, expectedResult: Int) {
        val calculator = Calculator()

        assertThat(calculator.calculate(input))
            .isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        fun equations(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//n\n378n15n667", 1060),
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("1,2:3", 6),
                Arguments.of("1,2", 3),
                Arguments.of("1", 1),
                Arguments.of("", 0),
                Arguments.of(null, 0),
            )
        }
    }
}
