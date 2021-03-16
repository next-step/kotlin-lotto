package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
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

    @ParameterizedTest
    @CsvSource(
        "1,2=3",
        "3,9=12",
        "13,987=1000",
        "1,2,3=6",
        "1,2,3,4,5,6,7,8,9,10=55",
        "876,54,3,21,0=954",
        delimiterString = "="
    )
    fun `여러 숫자와 그 사이에 쉼표가 있는 경우, 모든 숫자의 합을 반환`(expression: String, sum: Int) {
        assertThat(calculator.calculate(expression)).isEqualTo(sum)
    }

    @Test
    fun `구분자를 쉼표만이 아니라 콜론으로도 구분 가능`() {
        assertThat(calculator.calculate("1:2")).isEqualTo(3)
        assertThat(calculator.calculate("1:2:3:4:5:6:7:8:9:10")).isEqualTo(55)
        assertThat(calculator.calculate("876,54:3,21:0")).isEqualTo(954)
    }
}
