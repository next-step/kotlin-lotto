package stringaddcalculator

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class ExpressionTest {
    @ParameterizedTest
    @MethodSource("expressionParseTest")
    fun `Expression parse() 테스트`(expression: String, expect: List<Int>) {
        Assertions.assertThat(Expression(expression).parse()).isEqualTo(expect)
    }

    companion object {
        @JvmStatic
        private fun expressionParseTest(): List<Arguments> {
            return listOf(
                Arguments.of("1:2,3", listOf(1, 2, 3)),
                Arguments.of("//&\\n1&2:3", listOf(1, 2, 3)),
                Arguments.of("1,2//&\\n&3", listOf(1, 2, 3))
            )
        }
    }
}
