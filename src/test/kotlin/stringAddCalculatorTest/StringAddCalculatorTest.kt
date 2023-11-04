package stringAddCalculatorTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import stringAddCalculator.StringAddCalculator

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator.getInstance()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력한 문자열이 빈 문자열 또는 null이라면 0을 반환`(text: String?) {
        assertThat(calculator.calculate(text)).isZero()
    }

    @ParameterizedTest
    @MethodSource("generateInputAndExpected")
    fun `입력한 문자열의 합 계산`(text: String, expected: Int) {
        assertEquals(expected, calculator.calculate(text))
    }

    companion object {
        @JvmStatic
        private fun generateInputAndExpected(): List<Arguments?> {
            return listOf(
                Arguments.of(
                    "1,2,3", 6
                ),
                Arguments.of(
                    "1,2:3", 6
                ),
                Arguments.of(
                    "1:2:3", 6
                ),
                Arguments.of(
                    "//!\n1!2!3", 6
                ),
                Arguments.of(
                    "//!\n1:2!3,4", 10
                ),
            )
        }
    }
}
