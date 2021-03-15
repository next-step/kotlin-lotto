package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class StringAdditionCalculatorTest {
    private val calculator = StringAdditionCalculator()

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열이나 null이 주어질 경우, 0을 반환`(expression: String?) {
        assertThat(calculator.calculate(expression)).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 100])
    fun `숫자 하나가 주어질 경우, 해당 숫자를 반환`(integer: Int) {
        assertThat(calculator.calculate("$integer")).isEqualTo(integer)
    }
}
