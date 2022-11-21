package stringcalculator.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import stringcalculator.model.PositiveNumber

class StringAddCalculatorTest {
    @ParameterizedTest
    @CsvSource(value = ["1:2:3", "5:5:10", "1111:2222:3333"], delimiter = ':')
    internal fun `숫자들을 더한다`(addend: String, augend: String, expected: String) {
        val num1 = PositiveNumber.of(addend)
        val num2 = PositiveNumber.of(augend)
        val result = StringAddCalculator.add(num1, num2)
        assertThat(result).isEqualTo(PositiveNumber.of(expected))
    }
}
