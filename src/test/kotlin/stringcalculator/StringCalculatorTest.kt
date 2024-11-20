package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    @Test
    fun `문자열 계산기는 입력으로 문자열을 받는다`() {
        val stringCalculator = StringCalculator("1,2,3")
        assertThat(stringCalculator.inputString).isEqualTo("1,2,3")
    }
}
