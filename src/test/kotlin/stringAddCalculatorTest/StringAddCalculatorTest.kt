package stringAddCalculatorTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import stringAddCalculator.StringAddCalculator

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력한 문자열이 빈 문자열 또는 null이라면 0을 반환`(text: String?) {
        assertThat(calculator.calculate(text)).isZero()
    }
}
