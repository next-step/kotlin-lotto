package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringCalculatorTest {

    @Test
    fun `정해진 구분자로 숫자 string이 오면 모든 숫자를 더한다`() {
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate("1,2,3")).isEqualTo(6)
        assertThat(stringCalculator.calculate("1:2:3")).isEqualTo(6)
    }
}
