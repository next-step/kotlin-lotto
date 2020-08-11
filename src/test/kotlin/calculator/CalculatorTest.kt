package calculator

import calculator.domain.Calculator
import calculator.domain.Number
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("generateSumTestData")
    fun `파싱된 문자열의 합계`(numbers: List<Number>, expected: Int) {
        assertThat(Calculator().sum(numbers)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun generateSumTestData(): List<Arguments> {
            return listOf(
                Arguments.of(listOf(Number("1"), Number("2"), Number("3")), 6),
                Arguments.of(listOf(Number("11"), Number("21"), Number("31")), 63)
            )
        }
    }
}
