package stringaddcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

class AddCalculatorTest {
    private lateinit var addCalculator: AddCalculator

    @BeforeEach
    fun setUp() {
        addCalculator = AddCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null을 입력할 경우 0을 반환해한다`(expression: String?) {
        assertThat(addCalculator.calculate(expression)).isEqualTo(0)
    }
}
