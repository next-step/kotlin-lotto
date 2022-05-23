package stringaddcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
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

    @ParameterizedTest
    @CsvSource(value = ["1, 1", "100, 100", "0, 0", "-1, -1"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(expression: String, expect: Int) {
        assertThat(addCalculator.calculate(expression)).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource(value = ["'1,2',3", "'1,2,3,4,5',15"])
    fun `숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(expression: String, expect: Int) {
        assertThat(addCalculator.calculate(expression)).isEqualTo(expect)
    }
}
