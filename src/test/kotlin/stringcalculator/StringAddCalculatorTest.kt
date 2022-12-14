package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import stringcalculator.model.PositiveNumber

class StringAddCalculatorTest {
    @ParameterizedTest
    @CsvSource(
        value = [
            "1:2:3:4->10",
            "11,22,33,44->110",
            "111:222,333:444->1110",
            """//;\n1111;2222;3333;4444->11110""",
            """//E\n11111E22222E33333E44444->111110""",
        ],
        delimiterString = "->"
    )
    internal fun `문자열 덧셈 계산`(input: String, expected: String) {
        assertThat(StringAddCalculator.calculate(input)).isEqualTo(PositiveNumber.of(expected))
    }
}
