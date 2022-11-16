package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null을 입력할 경우 0을 반환한다`(text: String?) {
        assertThat(calculator.add(text)).isZero
    }

    @ParameterizedTest
    @ValueSource(strings= ["1", "3", "10"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(text: String) {
        assertThat(calculator.add(text)).isEqualTo(text.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings= ["1,3", "3:1"])
    fun `쉼표 또는 콜론을 구분자를 가지는 문자열의 숫자를 합하여 반환한다`(text: String) {
        assertThat(calculator.add(text)).isEqualTo(4)
    }

}
