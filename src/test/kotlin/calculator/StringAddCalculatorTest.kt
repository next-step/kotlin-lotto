package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private val calculator = StringAddCalculator()

    @Test
    fun `입력값이 빈 문자열 또는 null인 경우 0을 반환`() {
        assertThat(calculator.calculate("")).isEqualTo(0)
        assertThat(calculator.calculate(null)).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "5", "17"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자 반환`(text: String) {
        assertThat(calculator.calculate(text)).isEqualTo(text.toInt())
    }

    @Test
    fun `컴마를 구분자로 사용하는 경우`() {
        assertThat(calculator.calculate(",")).isEqualTo(0)
        assertThat(calculator.calculate("1,2")).isEqualTo(3)
        assertThat(calculator.calculate("1,2,3")).isEqualTo(6)
    }

    @Test
    fun `컴마와 콜론을 구분자로 사용하는 경우`() {
        assertThat(calculator.calculate(",2:3")).isEqualTo(5)
        assertThat(calculator.calculate("1,2:3")).isEqualTo(6)
        assertThat(calculator.calculate("1,2:3:4")).isEqualTo(10)
    }

    @Test
    fun `커스텀 구분자 지정하여 숫자들의 합 구하기`() {
        assertThat(calculator.calculate("//!\n1!2!3")).isEqualTo(6)
        assertThat(calculator.calculate("//;\n1;2;3;4")).isEqualTo(10)
    }
}
