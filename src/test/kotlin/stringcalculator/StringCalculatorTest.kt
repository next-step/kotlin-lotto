package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    @Test
    fun `정해진 구분자로 숫자 string이 오면 모든 숫자를 더한다`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("1,2,3")).isEqualTo(6)
        assertThat(stringCalculator.calculate("1:2:3")).isEqualTo(6)
    }

    @Test
    fun `정해진 문자 사이에 문자를 지정하면 그 문자도 구분자에 추가한다`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("//;\n1;2;3")).isEqualTo(6)
    }

    @Test
    fun `문자열의 음수가 오는 경우 예외를 던진다`() {
        val stringCalculator = StringCalculator()
        assertThatThrownBy { stringCalculator.calculate("-1,2,3") }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
