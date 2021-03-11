package calculator

import calculator.adder.PositiveAdder
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

internal class StringAddCalculatorTest {
    @ParameterizedTest
    @CsvSource(
        value = [
            "1:2,3|6",
            """//?\n1?2|3"""
        ],
        delimiter = '|'
    )
    fun `입력한 식을 더한다`(expression: String, expect: Int) {
        // given
        val adder = PositiveAdder()
        val calculator = StringAddCalculator(adder)

        // when
        val calculate = calculator.calculate(expression)

        // then
        assertThat(calculate).isEqualTo(expect)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈문자열과 null은 0을 반환한다`(expression: String?) {
        // given
        val adder = PositiveAdder()
        val calculator = StringAddCalculator(adder)

        // when
        val calculate = calculator.calculate(expression)

        // then
        assertThat(calculate).isEqualTo(0)
    }
}
