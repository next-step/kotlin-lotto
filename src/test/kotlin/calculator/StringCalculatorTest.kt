package calculator

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

class StringCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 을 입력할 경우 0을 반환해야 한다`(input: String?) {
        val calculator = StringCalculator()
        val calculateValue = calculator.calculate(input)
        Assertions.assertEquals(0, calculateValue)
    }
}
