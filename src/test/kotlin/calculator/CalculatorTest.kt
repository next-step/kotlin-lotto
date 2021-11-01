package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@Suppress("NonAsciiCharacters")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {

    @ParameterizedTest
    @MethodSource
    fun `주어진 수들에 대해서 올바르게 덧셈을 한다`(expression: String?, expected: Int) {
        val result = Calculator.calculate(expression)

        assertThat(result).isEqualTo(expected)
    }

    @Suppress("unused")
    private fun `주어진 수들에 대해서 올바르게 덧셈을 한다`() = listOf(
        Arguments.of("2,3,4", 9),
        Arguments.of("1,5,9", 15),
        Arguments.of("4,2,4", 10),
        Arguments.of(null, 0),
        Arguments.of("", 0),
        Arguments.of("0", 0),
    )
}
