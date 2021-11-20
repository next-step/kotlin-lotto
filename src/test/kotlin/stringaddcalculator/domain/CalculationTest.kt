package stringaddcalculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculationTest {
    @ParameterizedTest
    @ValueSource(strings = ["//^\n1^2:3,4", "//^\n"])
    fun `커스텀 구분자가 있는지 확인한다`(input: String) {
        assertThat(Calculation.hasCustomDelimiter(input)).isTrue
    }
}
