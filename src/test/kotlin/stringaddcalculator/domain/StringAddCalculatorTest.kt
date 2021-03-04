package stringaddcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열이나 null 값이 들어올 경우엔 0을 리턴한다")
    fun calculate() {
        val expression: String? = null
        val result = StringAddCalculator().calculate(expression)
        assertThat(result).isEqualTo(0)
    }
}
