package calculator

import calculator.domain.Calculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("generateSumTestData")
    fun `파싱된 문자열의 합계`(numbers: List<Int>, expected: Int) {
        assertThat(Calculator().sum(numbers)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun generateSumTestData(): List<Arguments> {
            return listOf(
                Arguments.of(listOf(1, 2, 3), 6),
                Arguments.of(listOf(11, 21, 31), 63)
            )
        }
    }
}
